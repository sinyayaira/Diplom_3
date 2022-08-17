package practikum;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseClient {

    static {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }

    protected RequestSpecification getRequestSpec(String token) {
        final RequestSpecification requestSpec = given()
            .header("Content-type", "application/json")
            ;

        if (token == null) {
            return requestSpec;
        } else {
            return requestSpec.header("Authorization", token);
        }
    }
}
