package practikum.pageobjectelements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    //раздел соусы
    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    SelenideElement sectionSauces;

    public void clickSectionSauces() {
        this.sectionSauces.parent().parent().click();
    }

    //раздел булки
    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    SelenideElement sectionBuns;

    public void clickSectionBuns() {
        this.sectionBuns.parent().parent().click();
    }

    //раздел начинки
    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    SelenideElement sectionToppings;

    public void clickSectionToppings() {
        this.sectionToppings.parent().parent().click();
    }

    //заголовок раздела соусы
    @FindBy(how = How.XPATH, using = "//h2[text()='Соусы']")
    SelenideElement SaucesHeader;

    public boolean isSaucesHeaderVisible() {
        return this.SaucesHeader.isDisplayed();
    }

    //заголовок раздела булки
    @FindBy(how = How.XPATH, using = "//h2[text()='Булки']")
    SelenideElement BunsHeader;

    public boolean isBunsHeaderVisible() {
        return this.BunsHeader.isDisplayed();
    }

    //заголовок раздела начинки
    @FindBy(how = How.XPATH, using = "//h2[text()='Начинки']")
    SelenideElement ToppingsHeader;

    public boolean isToppingsHeaderVisible() {
        return this.ToppingsHeader.isDisplayed();
    }

    //раздел личный кабинет
    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    SelenideElement ProfileSection;

    public void clickProfileSection() {
        this.ProfileSection.click();
    }

       //раздел конструктор
    @FindBy(how = How.LINK_TEXT, using = "Конструктор")
    SelenideElement SectionConstructor;

    public void clickSectionConstructor() {
        this.SectionConstructor.click();
    }

    //заголовок Соберите бургер
    @FindBy(how = How.XPATH, using = "//h1[text()='Соберите бургер']")
    SelenideElement CollectBurgerHeader;

    public boolean isCollectBurgerHeaderVisible() {
        return this.CollectBurgerHeader.isDisplayed();
    }

    //логотип
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    SelenideElement Logo;

    public void clickLogo() {
        this.Logo.click();
    }

    //кнопка войти аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    SelenideElement LoginInAccountButton;

    public void clickLoginInAccountButton() {
        this.LoginInAccountButton.waitUntil(visible,40001);
        this.LoginInAccountButton.click();
    }

    //кнопка оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    SelenideElement CreateOrderButton;

    public boolean isCreateOrderButtonVisible() {
        this.CreateOrderButton.waitUntil(visible, 4000);
        return this.CreateOrderButton.isDisplayed();
    }
}
