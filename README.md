# Swapi Testing Framework


```swapi``` is the testing framework for test tasks:

1) Find planet for people with id 3 
2) Find all peoples from space Droid

```swapi``` is based on maven project with:
 * language plugin ```groovy```
 * test framework ```spock``` 
 * API access framework -  ```restassured```
 * reporter - ```spock reporter```

## Quick start


1. Navigate to project's root directory:

        $ cd swapi/

2. Run the following maven command:

        $ mvn clean test

## Reports

#####Spock reports
Framework is configured to generate reports during the test run.
After the tests are done - HTML report may be found in:
```.target/spock-reports```