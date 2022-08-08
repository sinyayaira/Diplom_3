package practikum;

import com.codeborne.selenide.Selenide;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.BeforeClass;
import io.restassured.RestAssured;
import net.minidev.json.JSONObject;

public class UserDataTest {
    public static final String REGISTRATION_EMAIL = "mail"+ System.currentTimeMillis() + "@gmail.com";
    public static final String REGISTRATION_PASSWORD = "password"+ System.currentTimeMillis();
    public static final String REGISTRATION_NAME = "name"+ System.currentTimeMillis();
    public static final String AUTHORIZATION_EMAIL = "66@yandex.ru";
    public static final String AUTHORIZATION_PASSWORD = "6666666";

    public static void cleanup() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", REGISTRATION_EMAIL);
        requestParams.put("password", REGISTRATION_PASSWORD);
        requestParams.put("name", REGISTRATION_NAME);

        Response response = RestAssured.given()
                .header("Content-type", "application/json")
                .body(requestParams.toJSONString())
                .post("/api/auth/login");


        JsonPath jsonPath = response.jsonPath();
        String token = jsonPath.get("accessToken");
        if (token != null) {
            RestAssured.given()
                    .header("Authorization", token)
                    .when()
                    .delete("/api/auth/user");
        }
    }

}
