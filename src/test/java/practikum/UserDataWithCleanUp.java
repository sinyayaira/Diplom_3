package practikum;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.BeforeClass;

public class UserDataWithCleanUp extends UserDataTest {
    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        cleanup();
    }

    @After
    public void cleanUpEach() {
        cleanup();
    }
}
