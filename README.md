# POS System [Layered-Spring Data JPA with Maven]


In this **POS System** has all the functionalities of a POS system, like customer adding,item management,order placing,order viewing and order searching.It consists of five main parts;

    * Manage customers
    * Manage items
    * Placeorders
    * View orders
    * Search orders

## Dependencies

* [JFoenix](https://mvnrepository.com/artifact/com.jfoenix/jfoenix/8.0.10) - is an open source Java library, that implements Google Material Design using Java components.
* [MySQL Connector](https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.21) - MySQL Connector/J is the official JDBC driver for MySQL.
* [Project Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.12) - Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.
                                                                                          Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables and etc;
* [Spring Test Context Framework](https://mvnrepository.com/artifact/org.springframework/spring-test/5.2.8.RELEASE)                                                                                          
* [JUnit Test](https://mvnrepository.com/artifact/junit/junit/4.13) - JUnit is a unit testing framework for Java
* [Spring Data JPA](https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa/2.3.3.RELEASE)  

Further this POS System has implemented by using various technologies and frameworks.Click the above link to check those implementations.

[Different Implementations of POS System](https://github.com/poornimavithanage/PointOfSalesSystem-Layered-Architecture/blob/master/README.md)    

## Prerequisites

* Before use this application you must need to install [JAVA](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) runtime environment and [MYSQL](https://www.mysql.com/) database management services.

## Configurations

Find the resource directory from src/main/resources/application.properties and config the below properties with your dialect,database name,user name and password.

    javax.persistence.jdbc.driver=com.mysql.cj.jdbc.Driver
    javax.persistence.jdbc.url=jdbc:mysql://localhost:3306/hibernate_pos
    javax.persistence.jdbc.user=root
    javax.persistence.jdbc.password=mysql

## Maven

> Maven is project/build management tool.
  
  Instead of downloading and placing the jars manually in the project, we can use maven to automate the process. We can define the dependency in the **pom.xml (Project object model)**. Maven requires internet to download the jars, which is a one time process.

## [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

> Why use??

 When you implement a new application, you should focus on the business logic instead of technical complexity and boilerplate code. That’s why the Java Persistence API (JPA) specification and Spring Data JPA are extremely popular. JPA handles most of the complexity of JDBC-based database access and object-relational mappings.

## Spring

 Spring is the most popular application development framework for enterprise Java.
 The core features of the Spring Framework can be used in developing any Java application, but there are extensions for building web applications on top of the Java EE platform. Spring framework targets to make J2EE development easier to use and promotes good programming practices by enabling a POJO-based programming model.

## [Testing](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/testing.html)

> Why??

The Spring team advocates test-driven development (TDD).

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)


