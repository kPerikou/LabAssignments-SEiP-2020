# Design Patterns 

A module Maven project for familiarizing with design principles by refactoring code and applying design patterns on a given code base.

## Overview

This module supports 3 functionalities:
1. Source file reading
2. Source code analyzing
3. Metrics exporting


## Prerequisites

1. Install [Java JDK version 1.8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) (or later)
2. Setup Maven in Windows/Linux/Mac - [guidelines](https://www.baeldung.com/install-maven-on-windows-linux-mac)
3. Clone this repository


## Build project

1. In order to build the module `sourcecodeanalyzer` execute this command in the `seip2020_practical_assignments` directory:
```
mvn package jacoco:report
```

2. Run the executable by executing
```
java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
```

were args translate to: 
- arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
- arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
- arg2 = “SourceCodeLocationType” [local|web]
- arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
- arg4 = “OutputFileType” [csv|json]


Example: 
```
java –jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv
```


## Design Patterns Use

### Source file reading functionality
For the source file reading functionality are used mainly 3 design patterns:
1. Strategy pattern
2. Factory pattern
3. NullObject pattern

In particular:
1. Stratgegy pattern:
   - is used for making the source file readers (Local and Web) interchangeable. This pattern, supports the addition of more file storage places(places from where you can read a file, like from web or locally) with less changes in the Client side.
   - The sourceFileReader class is the interface and the LocalSourceFileReader and WebSourceFileReader are the implementations of the interface.
   - By applying this pattern the number of the classes was increased.
   

2. Factory pattern:
   - is used for separating the client from the SourceFileReader. By applying this pattern, you can extend the SourceFileReader hierarchy without affecting the client at all.
   - is achieved with the SourceFileReaderFactory class
   
3. Null Object pattern:
   - is used for simplifying client's code and remove the responsibility from the client side to hanlde any null cases.
   - is achieved with the SourceFileReader class
   - but it can cause harm by hiding errors and complicating testing
   
In addition, the SourceFileReader with its implementations participate in one more pattern, bridge pattern, that is analyzed below.


### Source code analyzing functionality
For the source code analyzing functionality is used 1 pattern:
1. Bridge pattern

In particular:
1. Bridge pattern:
   - is used for enhancing the independance between the two dimensions(Types of SourceCodeAnalyzer and types of SourceFileReader). By applying this pattern, adding new types of SourceFileReader does not affect the SourceCodeAnalyzer hierarchy and adding new SourceCodeAnalyzer needs minimum changes in the SourceFileReader.
   - SourceCodeAnalyzer is the abstract class and the RegexCodeAnalyzer and StrCompAnalyzer are the subclasses which extend this abstract class 
   - By applying this pattern the number of the classes was increased, so do the complexity as well.
   
   
### Metrics exporting functionality
For the metrics exporting functionality are used 2 patterns:
1. Factory pattern
2. Strategy pattern that is included in the factory pattern
3. Null Object pattern

In particular:
1. Factory pattern:
   - is used for enhancing the flexibility of the system, namely for extending the MetricsExporter hierarchy without affecting the client and providing a common interface to refer all objects. 
   - the above is achieved with MetricsExporterFactory class
   
2. Strategy pattern:
   - is used in order to support more options of output file types (such as csv and json) for future implementetions.
   - MetricsExporter is the interface class and the CsvExporter and NullExporter are the implementations of the interface.
   
3. Null Object pattern:
   - is used for simplifying client's code and remove the responsibility from the client side to hanlde any null cases, more specifically when the given output file type is unknown for the system.
   - is achieved with the NullExporter class
   - can cause harm by hiding errors and complicating testing
   
### System functionality

Due to the three above functionalities and the rise of the number of classes, the complexity of the system has been increased. So, in order to minimize client's complexity the Facade pattern is applied.
With this pattern, is defined a simplified interface for the system to the client and the independence is enhanced. This was achieved by adding the SourceFileAnalyzer class. With this class the subsystem is decoupled from client.


