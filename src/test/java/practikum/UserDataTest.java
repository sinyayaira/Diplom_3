package practikum;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.BeforeClass;

public class UserDataTest {
    public static final String EMAIL = "mail" + System.currentTimeMillis() + "@gmail.com";
    public static final String PASSWORD = "password" + System.currentTimeMillis();
    public static final String NAME = "name" + System.currentTimeMillis();

    protected static UserClient userClient = new UserClient();
    protected static ClientPOJO client = new ClientPOJO(EMAIL, NAME, PASSWORD);

    @BeforeClass
    public static void setUp() {
        cleanup();
    }

    @After
    public void cleanUpEach() {
        cleanup();
    }

    public static void cleanup() {
        Response response = userClient.login(client);

        JsonPath jsonPath = response.jsonPath();
        String token = jsonPath.get("accessToken");
        if (token != null) {
            userClient.delete(token);
        }
    }
}