import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DummyRestApiTest {

    private static final Logger LOG = Logger.getLogger(DummyRestApiTest.class);

    @BeforeClass
    public void setUp(){

        //Setting up base URI
        RestAssured.baseURI = Endpoints.BASE_URI;
    }

    @Test(priority = 1)
    public void createEmployee(){

        // Using HTTP method POST to create new employee
        String requestBody = UserInfo.request_post;
        Response response = null;
        try{
            response = given().contentType(ContentType.JSON).body(requestBody).post(Endpoints.POST);
        }catch (Exception e){
            e.printStackTrace();
        }

        // Assigning the value returned by static method 'get_id' of the 'ID' class to a static variable 'the_id'
        // specified in the 'ID' class.
        // This variable is used as id-part of the endpoints for 'put' and 'delete' methods.
        ID.the_id = ID.get_id(response.asString());

        // Verification of the '200' status code
        assertEquals(200, response.getStatusCode());

        LOG.info("TEST 1: Creating new user" + "\nResponse :" + response.getBody().asString()
                + "\nStatus code :" + response.getStatusCode());
    }

    @Test(priority = 2)
    public void checkEmployees(){

        // Using HTTP method GET to get the response from the server
        Response response = null;
        try{
            response = given().when().get(Endpoints.GET);
        }catch (Exception e){
            e.printStackTrace();
        }

        // Checking if there's employee with specific name
        assertTrue(response.asString().contains(UserInfo.post_name));

        LOG.info("TEST 2: Verifying user is created - SUCCESS"
                + "\nStatus code :" + response.getStatusCode());
    }

    @Test(priority = 3)
    public void updateEmployee() {

        // Using HTTP method PUT to update employee's info
        String requestBody = UserInfo.request_put;
        Response response = null;
        try {
            response = given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .put( Endpoints.PUT + ID.the_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Checking if there's employee with specific updated name
        assertTrue(response.asString().contains(UserInfo.put_name));

        LOG.info("TEST 3: Updating user info" + "\nResponse :" + response.getBody().asString()
                + "\nStatus code :" + response.getStatusCode());
    }

    @Test(priority = 4)
    public void deleteEmployee() {

        // Using HTTP method DELETE to remove employee from the database
        Response response = null;
        try {
            response = given()
                    .contentType(ContentType.JSON)
                    .delete(Endpoints.DELETE + ID.the_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Checking if the response contains word 'deleted' meaning the user has been removed from the database
        assertTrue(response.asString().contains(UserInfo.deleted));

        LOG.info("TEST 4: Removing the user" + "\nResponse :" + response.getBody().asString()
                + "\nStatus code :" + response.getStatusCode());
    }

    @AfterClass
    public void tearDown(){
        LOG.info("All tests PASSED!");
    }
}
