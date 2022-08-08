package practikum.authorization;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import practikum.pageobjectelements.ProfilePage;
import practikum.pageobjectelements.MainPage;
import practikum.UserDataTest;
import practikum.pageobjectelements.RecoverPasswordPage;
import practikum.pageobjectelements.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class AuthorizationTest extends UserDataTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        cleanup();
    }

    @AfterClass
    public static void cleanUpAfterAllTest() {
        cleanup();
    }

    @Before
    public void clearBrowserCookies() {
        Selenide.clearBrowserCookies();
        Selenide.close();
        open(MainPage.URL, MainPage.class);
    }

    @Test
    @DisplayName("Check authorization by LoginButton on main page")
    public void authorizationByLoginButtonOnMainPage() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickLoginInAccountButton();
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.setEmail(AUTHORIZATION_EMAIL);
        profilePage.setPassword(AUTHORIZATION_PASSWORD);
        profilePage.loginButtonClick();

        assertTrue("Пользователь не авторизовался", mainPage.isCreateOrderButtonVisible());

    }

    @Test
    @DisplayName("Check authorization by Profile Section on main page")
    public void authorizationByProfileSection() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickProfileSection();
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.setEmail(AUTHORIZATION_EMAIL);
        profilePage.setPassword(AUTHORIZATION_PASSWORD);
        profilePage.loginButtonClick();

        assertTrue("Пользователь не авторизовался", mainPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("Check authorization by Registration page")
    public void authorizationByRegistrationPage() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickProfileSection();
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickRegistrationLink();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.clickLoginButtonOnRegistrationPage();

        profilePage.setEmail(AUTHORIZATION_EMAIL);
        profilePage.setPassword(AUTHORIZATION_PASSWORD);
        profilePage.loginButtonClick();

        assertTrue("Пользователь не авторизовался", mainPage.isCreateOrderButtonVisible());

    }

    @Test
    @DisplayName("Check authorization by Recover Password page")
    public void authorizationByRecoverPasswordPage() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickProfileSection();
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickRecoverPasswordLink();

        RecoverPasswordPage recoverPasswordPage = page(RecoverPasswordPage.class);
        recoverPasswordPage.clickLoginButtonOnRecoverPasswordPage();

        profilePage.setEmail(AUTHORIZATION_EMAIL);
        profilePage.setPassword(AUTHORIZATION_PASSWORD);
        profilePage.loginButtonClick();

        assertTrue("Пользователь не авторизовался", mainPage.isCreateOrderButtonVisible());

    }

    @Test
    @DisplayName("Check exit by LogOut Button")
    public void exitByLogOutButton() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickProfileSection();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.setEmail(AUTHORIZATION_EMAIL);
        profilePage.setPassword(AUTHORIZATION_PASSWORD);
        profilePage.loginButtonClick();

        mainPage.clickProfileSection();

        profilePage.clickLogOutButton();

    }
}
