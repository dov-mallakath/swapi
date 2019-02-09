# Swapi Testing Framework


```swapi``` is the testing framework for test tasks:

1) Find planet for people with id 3 
2) Find all peoples from space Droid

It's based on maven project with:
 * test framework -  ```tesng```
 * API access framework -  ```restassured```
 * reporter - ```allure-maven-plugin```

## Quick start


1. Navigate to project's root directory:

        $ cd swapi/

2. Run the following maven command:

        $ mvn clean test -Dtesting.suiteXmlFile=src/test/resources/swapi-testtask-regression-suite.xml

## Reports

#####Allure reports
Framework contains:
 1. Allure TesNG Adaptor dependency to collect all information about running tests and to have an ability to use framework annotations.
     All information is saved in XML files in the directory: ```./target/allure-results```
     Run the build to get test results:
     ```
     mvn clean test
     ```
 2. Allure Maven Plugin which generates Allure report from existing XML files during Maven build.
    Generate the report:
    ```
    mvn site
    ```
    HTML report will be generated into ```./target/site/allure-maven-plugin```
