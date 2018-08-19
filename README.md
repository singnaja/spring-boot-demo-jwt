# spring-boot-demo-jwt

Demo Project

# Definition of the Scenario

We need new registration service for mobile application. Please provide JAVA
Restful API for user to register and get user information after registration. Try
your best to deliver 2 API services with security

business logic below.
- Register process has to generate reference code from register date and
last 4 digits of phone number like this “YYYYMMDDXXXX” (ex.
201708154652) and keep it in database.
- Member type classify from salary
o Platinum (salary > 50,000 baht)
o Gold (salary between 30,000 to 50,000)
o Silver (salary < 30,000)
- Reject if salary < 15,000 with error code (please define error code)

# Pre Requesting

- JDK 1.8
- IDE (spring tool suite)
- jwt
- Maven
- mockito
- tomcat 
- h2
- REST client (eg. Postman )



# Design

in path asc-demo-spring-boot-jwt/ASC_DEMO/document/design

# Test

in path asc-demo-spring-boot-jwt/ASC_DEMO/document/testcases

# Run

java -jar spring-boot-demo-jwt-0.0.1-SNAPSHOT.jar
