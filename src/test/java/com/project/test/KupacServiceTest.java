package com.project.test;

import com.project.persistence.Kupac;
import com.project.service.KupacService;
import com.project.service.SessionCreator;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class KupacServiceTest {

    private static KupacService kupacService;

    @BeforeAll
    static void setup() {
        SessionCreator.init("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        kupacService = new KupacService();
        kupacService.init();
    }

    @AfterAll
    public void teardown() {
        kupacService.close();
    }

    @Test
    public void testRegisterAndLoginKupac() {
        Kupac kupac = new Kupac("Jovan", "Jovic", "jj@mail.com", "pswrd");
        kupacService.addKupac(kupac);

        Kupac fetched = kupacService.findByEmailAndPassword("jj@mail.com", "pswrd");
        Assertions.assertNotNull(fetched);
        Assertions.assertEquals("Jovan", fetched.getIme());
    }

    @Test
    public void testFindByEmailReturnsNullIfNotExists() {
        Kupac fetched = kupacService.findByEmail("OVO_NE_POSTOJI");
        Assertions.assertNull(fetched);
    }

    // @Test
    // public void testRemoveKupac() {
    // Kupac kupac = new Kupac("Jovan", "Jovic", "jj@mail.com", "pswrd");
    // kupacService.addKupac(kupac);
    //
    // kupacService.removeKupac(kupac);
    // Kupac fetched = kupacService.findByEmailAndPassword("jj@mail.com", "pswrd");
    // Assertions.assertNull(fetched);
    // }
}
