package practikum.navigation;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import practikum.pageobjectelements.MainPage;
import practikum.pageobjectelements.ProfilePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class GoToSectionOnMainPageTest {

    @BeforeClass
    public static void clear() {
        Selenide.clearBrowserCookies();
        Selenide.close();
        open(MainPage.URL, MainPage.class);
    }

    @Test
    @DisplayName("Check go to section sauces")
    public void goToSectionSauces() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickSectionSauces();
        assertTrue("Раздел Соусы не отображается", mainPage.sectionSaucesShouldHave());
    }

    @Test
    @DisplayName("Check go to section Buns")
    public void goToSectionBuns() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickSectionBuns();
        //assertTrue("Раздел Булки не отображается", mainPage.sectionBunsShouldHave());
    }

    @Test
    @DisplayName("Check go to section Toppings")
    public void goToSectionToppings() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickSectionToppings();
        //assertTrue("Раздел Начинки не отображается", mainPage.sectionToppingsShouldHave());
    }

    @Test
    @DisplayName("Check go to section Profile")
    public void goToSectionProfile() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickProfileSection();
        ProfilePage profilePage = page(ProfilePage.class);
        assertTrue("Переход в раздел личный кабинет не произошёл", profilePage.isLoginButtonVisible());
    }

    @Test
    @DisplayName("Check go to section Constructor from Profile")
    public void goToSectionConstructor() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickProfileSection();
        mainPage.clickSectionConstructor();
        assertTrue("Переход к разделу Конструктор не произошёл", mainPage.isCollectBurgerHeaderVisible());
    }

    @Test
    @DisplayName("Check go to section Constructor from Profile by Logo")
    public void goToSectionConstructorByLogo() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickProfileSection();
        mainPage.clickLogo();
        assertTrue("Переход к разделу Конструктор не произошёл", mainPage.isCollectBurgerHeaderVisible());
    }
}

