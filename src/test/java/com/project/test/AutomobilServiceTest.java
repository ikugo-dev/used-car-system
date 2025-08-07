package com.project.test;

import com.project.persistence.Automobil;
import com.project.service.AutomobilService;
import com.project.service.SessionCreator;

import org.junit.jupiter.api.*;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AutomobilServiceTest {

    private static AutomobilService automobilService;

    @BeforeAll
    public static void setup() {
        SessionCreator.init("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        automobilService = new AutomobilService();
        automobilService.init();
    }

    @AfterAll
    public void tearDown() {
        automobilService.close();
    }

    @Test
    public void testAddAndRetrieveCar() {
        Automobil car = new Automobil("Toyota", "Yaris", 2018, 5000.0, "AutoShop");
        automobilService.addCar(car);

        List<Automobil> cars = automobilService.getAllCars();
        Assertions.assertTrue(cars.stream().anyMatch(c -> "Toyota".equals(c.getMarka())));
    }

    @Test
    public void testRemoveCar() {
        Automobil car = new Automobil("Test", "Remove", 2000, 1.0, "Nobody");
        automobilService.addCar(car);

        List<Automobil> carsBefore = automobilService.getAllCars();
        automobilService.removeCar(carsBefore.get(carsBefore.size() - 1));
        List<Automobil> carsAfter = automobilService.getAllCars();

        Assertions.assertTrue(carsAfter.size() < carsBefore.size());
    }
}
