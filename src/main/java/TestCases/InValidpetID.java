package TestCases;

import Common.DataProvider.DataProvider2;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.lang.*;
import static io.restassured.RestAssured.given;

public class InValidpetID extends Common.LogReport.ExtentReport{

    @Test
            (dataProvider = "TESTDATA2" , dataProviderClass = DataProvider2.class)
    public void InValidpetID(String InValidpetID) {


        try {

            // Build the Request
            String id ;
            RequestSpecBuilder builder;
            builder = new RequestSpecBuilder();
            RequestSpecification requestSpec = builder.build();
            builder.setContentType("application/json");
            Response response = given().spec(requestSpec).when().get("https://petstore.swagger.io/v2/pet/"+InValidpetID);

            //start testing
            logger = report.startTest("Find By pet |  Pet ID not found validation ");


            if (response.statusCode()==404) {   // >>>> validate response for pet ID
                if (response.getBody().asString().contains("Pet not found")){

                    getLogger().log(LogStatus.PASS, "Response Generate succesfully with valid error message");
                    getLogger().log(LogStatus.INFO,"Error Response Body : " + response.getBody().asString());
                }

                else {

                    getLogger().log(LogStatus.ERROR, "Response Not as Expected ");
                    getLogger().log(LogStatus.INFO,"Error Response Body : " + response.getBody().asString());

                }
            }

            else {

                getLogger().log(LogStatus.ERROR, "Response Not Generate succesfully");
                getLogger().log(LogStatus.INFO,"Response Body : " + response.getBody().asString());

            }
        } catch (Exception e) {

            e.printStackTrace();
            getLogger().log(LogStatus.WARNING,e.toString());
        }
    }
}
