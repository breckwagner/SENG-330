# Installing


Ensure you have the following software installed

Java 1.8

Gradle


Compiling and running the program is done with

Compiling:

gradle build

this will generate files inside a folder called build, then the user can navigate to the build/classes/main directory.

The program can be run by typing
'java Interface'

this will start the interface class which includes the main().

Generating the documentation can be done by:

```shell
$ pdflatex document.tex
```

HOW TO RUN JUNIT TESTCASES
windows
javac -cp .;junit-4.12.jar TestCases.java
java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestCases

linux
javac -cp .:junit-4.12.jar TestCases.java
java -cp .:junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestCases
