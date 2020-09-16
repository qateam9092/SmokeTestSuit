package TestCases;

import Common.DataProvider.DataProvider2;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.lang.*;
import static io.restassured.RestAssured.given;

public class ValidpetID extends Common.LogReport.ExtentReport{

    @Test
            (dataProvider = "TESTDATA1" , dataProviderClass = DataProvider2.class)
    public void ValidpetID(

            String ValidpetID

            )

    {

        try {

            // Build the Request
            RequestSpecBuilder builder;
            builder = new RequestSpecBuilder();
            RequestSpecification requestSpec = builder.build();
            builder.setContentType("application/json");
            Response response = given().spec(requestSpec).when().get("https://petstore.swagger.io/v2/pet/"+ValidpetID);

            //start testing
            logger = report.startTest("Find by Pet | Vaild pet id");


            if (response.statusCode()==200) {   // >>>> validate response status code

                if (response.getBody().asString().contains("category"))
                {
                    getLogger().log(LogStatus.PASS, "Response Generate succesfully with pet  detiles  ");
                    getLogger().log(LogStatus.INFO," Response Body : " + response.getBody().asString());
                }

                else {

                    getLogger().log(LogStatus.FAIL,"Response not Generate sold status code with valid information  ");
                    getLogger().log(LogStatus.INFO," Response Body : " + response.getBody().asString());

                }
            }

            else {

                getLogger().log(LogStatus.ERROR, "Response Not Generate ");
                getLogger().log(LogStatus.INFO,"Error Response Body : " + response.getBody().asString());

            }
        } catch (Exception e) {

            e.printStackTrace();
            getLogger().log(LogStatus.WARNING,e.toString());
        }
    }
}
