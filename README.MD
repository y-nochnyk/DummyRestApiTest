# GitHubAPITest
GitHub API test using TestNG, Gson and RestAssured frameworks.
## Prerequisites
* **JDK version >= 11.0.1**
* **Apache Maven version >= 3.6.0**
## Project structure
* [src/main/java/Endpoints.java](https://github.com/y-nochnyk/DummyRestApiTest/blob/master/src/main/java/Endpoints.java) - the class, where all the endpoints are specified
* [src/main/java/ID.java](https://github.com/y-nochnyk/DummyRestApiTest/blob/master/src/main/java/ID.java) - the class, which contains method to get the ID being used as the part of endpoints to update and remove user
* [src/test/java/UserInfo.java](https://github.com/y-nochnyk/DummyRestApiTest/blob/master/src/main/java/UserInfo.java) - the class that contains all the user info fields being used for HTTP requests and tests assertion
* [src/test/java/Log.java](https://github.com/y-nochnyk/DummyRestApiTest/blob/master/src/main/java/Log.java) - the class, which contains the method to print log messages according to test results
* [src/test/java/DummyRestApiTest.java](https://github.com/y-nochnyk/DummyRestApiTest/blob/master/src/test/java/DummyRestApiTest.java) - the class where all the tests are stored
## Run 
**To run tests from the terminal use:** 
```
mvn clean install
```
