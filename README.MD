# GitHubAPITest
GitHub API test using TestNG, Jackson Databind and Spring-Web frameworks.
## Prerequisites
* **JDK version >= 11.0.1**
* **Apache Maven version >= 3.6.0**
## Project structure
* [src/main/resources/Info.txt](https://github.com/y-nochnyk/GitHubAPITest/blob/master/src/main/resources/Info.txt) - detailed information about all the tests
* [src/main/java/BaseUser.java](https://github.com/y-nochnyk/GitHubAPITest/blob/master/src/main/java/BaseUser.java) - the class describes a specific user's info
* [src/test/java/GitHubUser.java](https://github.com/y-nochnyk/GitHubAPITest/blob/master/src/main/java/GitHubUser.java) - the class that contains all the fields being mapped from the JSON-response from the GitHub
* [src/main/java/Endpoints.java](https://github.com/y-nochnyk/GitHubAPITest/blob/master/src/main/java/Endpoints.java) - the class where the GitHub URL field is specified
* [src/test/java/GitHubTest.java](https://github.com/y-nochnyk/GitHubAPITest/blob/master/src/test/java/GitHubTest.java) - the class where all the tests are stored
## Run 
* **To run tests from the terminal use:** 
```
mvn clean install
```
