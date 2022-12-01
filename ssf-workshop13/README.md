## Workshop 13

* Run the spring boot app

Linux/Macos
```
mvn spring-boot:run -Dspring-boot.run.arguments=--dataDir=/Users/cws/code/VISA-SDF/LessonCode/SSF/SSF-WORKSHOP13/contacts 
```

* Incorporate test started dependencies to pom.xml
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <version>2.7.1<.version>
    <scope>test</scope>
</dependency>
```

* In order to tun the test case
```
mvn test
```
```
mvn package
````
