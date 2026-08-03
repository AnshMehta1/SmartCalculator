# Maven Answers

## B2.1

The lifecycle phases executed by `mvn package` are:

1. validate
2. compile
3. test
4. package

## B2.2

mvn package compiles, tests, and packages the project into a JAR.

mvn install performs everything that package does and additionally installs the artifact into the local Maven repository so other local projects can use it.

## B2.3

JUnit should use the test scope because it is only needed while running tests. It is not required in the final application, reducing the production artifact size and avoiding unnecessary runtime dependencies.