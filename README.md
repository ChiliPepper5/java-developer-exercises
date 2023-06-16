# Java / Spring Exercises

This project includes several exercises to test some basic Java and Spring skills.
Complete the exercises to the best of your ability and submit your results as a pull request.

## Java Data Structures
- The test directory includes 5 exercises captured as unit tests
- You can choose to complete the exercises using Java or Groovy
    - `src/test/java/TestInJava.java`
    - `src/test/groovy/TestInGroovy.groovy`

## Spring Application Development
### Project Details
   - The project includes the minimum necessary dependencies needed to complete exercises, but you can import others if you desire.
   - The project supports Java or Groovy code, so you can use either language to complete the exercises.
   - The two files you will need to modify are:
     - `src/main/groovy/com/onboarding/controllers/YearlyRateController.java`
     - `src/main/groovy/com/onboarding/services/YearlyRateService.java`

### Specific Tasks
    - Make YearlyRateService a Spring bean

    - Inject the YearlyRateService into YearlyRateController

    - Implement an endpoint in YearlyRateController to return the rates for a specific year
      The year should be supplied as a path variable (e.g. /year/1999/ )
      If the year is found, return the rate information, otherwise throw a 404
     
    - Implement an endpoint in YearlyRateController to return a list of rates for a particular set of years
      You can decide how the caller should supply the year boundaries
      Return any results in a list (e.g. no results return an empty list)


