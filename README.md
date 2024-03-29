# spring-blog
Spring Boot blog app
## About
This is a simple blogging application.
![alt text](pics/1.png)
![alt text](pics/2.png)
![alt text](pics/3.png)

The security configuration:
- everybody can view the posts and comments
- authenticated users (with ROLE_USER and ROLE_ADMIN) can add comments
- only users with ROLE_ADMIN can add posts
## Technologies used
Spring Boot, Spring MVC, Spring Security, Spring Data JPA, Hibernate, Thymeleaf, H2 db.
## How to run

on windows:
```
mvnw spring-boot:run
```
on mac:
```
./mvnw spring-boot:run
```


**This app is using lightweight, embedded database H2.**

**Alternatively**, there is a version of the app using MySQL db on the mysql-db-version. To run the app make sure your username and password to access MySQL db are matching with application.properties file. 
You also need to have a database created with name matching the configuration. 
There is no need to create specific tables because Hibernate will do it automatically.
```
spring.datasource.url=jdbc:mysql://localhost:3306/blog2?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
```
