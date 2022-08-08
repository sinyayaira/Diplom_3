package practikum.registration;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import practikum.UserDataTest;
import practikum.UserDataWithCleanUp;
import practikum.pageobjectelements.MainPage;
import practikum.pageobjectelements.ProfilePage;
import practikum.pageobjectelements.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends UserDataWithCleanUp {

    @Before
    public void clearBrowserCookies() {
        Selenide.clearBrowserCookies();
        open(MainPage.URL, MainPage.class);
    }

    @Test
    @DisplayName("Check successful registration")
    public void successfulRegistration() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickProfileSection();
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickRegistrationLink();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setName(REGISTRATION_NAME);
        registrationPage.setEmail(REGISTRATION_EMAIL);
        registrationPage.setPassword(REGISTRATION_PASSWORD);

        registrationPage.clickRegisterButton();

        assertTrue("Регистрация не завершилась", profilePage.isLoginButtonVisible());
    }

    @Test
    @DisplayName("Check registration with incorrect password")
    public void registrationWithIncorrectPassword() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickProfileSection();
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickRegistrationLink();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setName(REGISTRATION_NAME);
        registrationPage.setEmail(REGISTRATION_EMAIL);
        registrationPage.setPassword("qazxs");

        registrationPage.clickRegisterButton();
        assertTrue("Ошибка - некорректный пароль", registrationPage.isMassageAboutIncorrectPasswordVisible());

    }
}
