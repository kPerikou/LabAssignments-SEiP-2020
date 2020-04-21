# Unit Testing

A module Maven project for demonstrating unit testing and familiarize with continues integration.

## Overview

This module contains 4 Java source files and their respective test files. 

The 3 Java source files are:
- ArithmeticOperations 
- ArrayOperations
- MyMath

 These are located in the [math package](src/main/java/math) as their functionality concerns math operations.

The fourth Java source file is:
- FileIO

 This is located in the [io package](src/main/java/io).

For each of those files exists a test class in the corresponding test package, namely in the [test math package](src/test/java/math) and [test io package](src/test/java/io).


### Prerequisites

1. Install [Java JDK version 1.8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) (or later)
2. Setup Maven in Windows/Linux/Mac - [guidelines](https://www.baeldung.com/install-maven-on-windows-linux-mac)
3. Clone this repository


### Build project 

In order to build the module unittesting execute this command in the `seip2020_practical_assignments` directory:

```
mvn package jacoco:report
```

Concerning unit testing, the above command:
1. Creates a report of the code coverage produced by jaCoCo. The report is located in the following path for the unittesting module:

   ```
   target/site/jacoco
   ```
   
   By clicking the index.html in the above file you can review the code coverage report.
   
   
2. Runs the tests which are located on the following path:

   ```
   src/test/java
   ```
   
   _**Note:** Only the test classes with a `Test` suffix which located in the `src/test` will be executed (not the MyMathTestSuite class)_


### Test project

In order to run directly the unit tests, execute the following command:

```
mvn test
```

_**Note:** Only the test classes with a `Test` suffix which located in the `src/test` will be executed (not the MyMathTestSuite class)_

The MyMathTestSuite, which groups the *MyMathTest* and *MyMathFactorialParameterizedTest* test classes, can be executed as following in the `unittesting` directory:

```
mvn -Dtest=MyMathTestSuite test
```


### Dependencies

In order to create and run the tests for the Java source files we use the JUnit 4 - test framework. To achieve this, the main POM (parent's pom.xml file) includes the following `junit` dependency:

```xml
<!-- https://mvnrepository.com/artifact/junit/junit -->
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.12</version>
	<scope>test</scope>
</dependency>
```

We need the following Mockito dependency, which exists in the main POM, so that the tests are written in an isolated environment: 

```xml
<!-- https://mvnrepository.com/artifact/org.mockito/mockito-core -->
<dependency>
	<groupId>org.mockito</groupId>
	<artifactId>mockito-core</artifactId>
	<version>2.27.0</version>
	<scope>test</scope>
</dependency>
```

*Note: Mockito dependency is needed for the ArrayOperationsTest file*


### Code Coverage report generator

As it is mentioned above, this module uses JaCoCo code coverage report generator. In order to enable this JaCoCo code coverage reporting, in the main POM (parent's pom.xml file) is included this `jacoco-maven-plugin`:

```xml
<plugin>
	<groupId>org.jacoco</groupId>
	<artifactId>jacoco-maven-plugin</artifactId>
	<version>0.8.3</version>
	<executions>
		<execution>
			<id>prepare-agent</id>
			<goals>
				<goal>prepare-agent</goal>
			</goals>
		</execution>
	</executions>
</plugin>
```


### Continuous Integration service

This project uses Travis CI service for building and running the tests. For each commit that was pushed to GitHub for the purposes of this module, automatically Travis CI built and ran the tests for the whole project. 
