FROM eclipse-temurin:23-jdk
WORKDIR /app
COPY tools/payara-micro.jar ./payara-micro.jar
COPY target/cars-project.war ./cars-project.war
EXPOSE 8080
CMD ["java", "-jar", "payara-micro.jar", "--deploy", "cars-project.war"]
