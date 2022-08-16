package practikum.pageobjectelements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;

public class ProfilePage {

    //ссылка Зарегистироваться
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Зарегистрироваться')]")
    SelenideElement registrationLink;

    @Step
    public void clickRegistrationLink() {
        registrationLink.click();
    }

    //кнопка войти
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    SelenideElement loginButton;

    @Step
    public boolean isLoginButtonVisible() {
        loginButton.waitUntil(visible, 4000);
        return loginButton.isDisplayed();
    }

    @Step
    public void loginButtonClick() {
        loginButton.click();
    }

    //поля ввода данных профиля
    @FindBy(tagName = "input")
    List<SelenideElement> inputs;

    @Step
    public void setEmail(String email) {
        inputs.get(0).sendKeys(email);
    }

    @Step
    public void setPassword(String password) {
        inputs.get(1).sendKeys(password);
    }

    //ссылка для восстановления пароля
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Восстановить пароль')]")
    SelenideElement recoverPasswordLink;

    @Step
    public void clickRecoverPasswordLink() {
        recoverPasswordLink.click();
    }

    //кнопка выйти
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    SelenideElement logOutButton;

    @Step
    public void clickLogOutButton() {
        logOutButton.click();
    }
}
