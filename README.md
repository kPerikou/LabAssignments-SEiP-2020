# LabAssignments-SEiP-2020

This repository serves as a storage for my assignments for the needs of the Software Engineering in Practice (SEiP) course during my 6th semester offered by the Department of Management Science & Technology of Athens University of Economics and Business.

## Overview

This repository contains the `seip2020_practical_assignments` multi-module Maven project. Its sub-module corresponds to one assignment.

The project consists of the following modules:
 - [gradeshistogram module](seip2020_practical_assignments/gradeshistogram), which concerns a Java application that reads a file, which contains students' grades, and generates a histogram
 - [unittesting module](seip2020_practical_assignments/unittesting), which contains Java source files and their respective test files


### Prerequisites

1. Install [Java JDK version 1.8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) (or later)
2. Setup Maven in Windows/Linux/Mac - [guidelines](https://www.baeldung.com/install-maven-on-windows-linux-mac)
3. Clone this repository

### Running the project

In order to build all modules execute this command in the repository `seip2020_practical_assignments` directory:

```
mvn package
```

