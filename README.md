# pexaparkTechnicalTask

This task is automated using selenium webdriver, cucumber and java. It is a BDD approach to write automation test script
to test the web application. This framework is used to write and execute automated acceptance tests. 

# Pre-requisites
- Java
- Maven
- Intellij
- Cucumber
- Selenium WebDriver

# Tests

The test cases are written in BDD format using Gherkin language. I have selected some tests cases which are suitable 
for automation testing (smoke/regression). There is still scope of automating more tests
but the application has defects right now so when the manual tests are failing is it not a 
good practice to automate them. 

The location of the tests are:

 - src/test/resources/features

# How to run the tests
The tests are tagged as smoke and regression. Smoke tests are high level tests only runs the important
tests which we run when the developer handed the code for testing. On the other hand regression tests are
all tests which are intended to run when all the manual testing is finished and to make sure the new code is not breaking 
existing code.

We can run the tests either using mvn command
- Open Terminal / cmd
- Navigate to the project folder
- run mvn test

or we can run the tests directly from runner class
- open src/test/java/runners/TestRunner
- We can specity what test to run using tags eg @smoke/@regression
- right click and click on 'Run TestRunner'

# Reports

I used ExtentSparkReport to generate test reports. Once the test execution is completed, 
the test report can be found in the below location

pexaparkTechnicalTask/test-output/SparkReport/PexaparkTestReport.html

Open the above file in any browser to check the reports generated.


