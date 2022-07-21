FROM openjdk:11
ADD target/employee-api.jar employee-api.jar
ENTRYPOINT ["java", "-jar", "employee-api.jar"]