package practikum.pageobjectelements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    //раздел соусы
    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    SelenideElement sectionSauces;

    @Step
    public void clickSectionSauces() {
        sectionSauces.parent().click();
    }

    @Step
    public boolean sectionSaucesShouldHave() {
        sectionSauces.parent().shouldHave(cssClass("tab_tab_type_current__2BEPc"));
        return true;
    }

    //раздел булки
    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    SelenideElement sectionBuns;

    @Step
    public void clickSectionBuns() {
        sectionBuns.parent().click();
    }

    @Step
    public boolean sectionBunsShouldHave() {
        sectionBuns.parent().shouldHave(cssClass("tab_tab_type_current__2BEPc"));
        return true;
    }

    //раздел начинки
    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    SelenideElement sectionToppings;

    @Step
    public void clickSectionToppings() {
        sectionToppings.parent().click();
    }

    @Step
    public boolean sectionToppingsShouldHave() {
        sectionToppings.parent().shouldHave(cssClass("tab_tab_type_current__2BEPc"));
        return true;
    }


    //раздел личный кабинет
    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    SelenideElement profileSection;

    @Step
    public void clickProfileSection() {
        profileSection.click();
    }

       //раздел конструктор
    @FindBy(how = How.LINK_TEXT, using = "Конструктор")
    SelenideElement sectionConstructor;

    @Step
    public void clickSectionConstructor() {
        sectionConstructor.click();
    }

    //заголовок Соберите бургер
    @FindBy(how = How.XPATH, using = "//h1[text()='Соберите бургер']")
    SelenideElement collectBurgerHeader;

    @Step
    public boolean isCollectBurgerHeaderVisible() {
        return collectBurgerHeader.isDisplayed();
    }

    //логотип
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    SelenideElement logo;

    @Step
    public void clickLogo() {
        logo.click();
    }

    //кнопка войти аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    SelenideElement loginInAccountButton;

    @Step
    public void clickLoginInAccountButton() {
        loginInAccountButton.waitUntil(visible,40001);
        loginInAccountButton.click();
    }

    //кнопка оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    SelenideElement createOrderButton;

    @Step
    public boolean isCreateOrderButtonVisible() {
        createOrderButton.waitUntil(visible, 4000);
        return createOrderButton.isDisplayed();
    }
}
