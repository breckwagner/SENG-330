# Installing



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