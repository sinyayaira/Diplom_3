package practikum.pageobjectelements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class RegistrationPage {

    //кнопка Зарегистрироваться
    @FindBy(how = How.TAG_NAME, using = "button")
    SelenideElement registrationButton;

    //поля ввода данных профиля
    @FindBy(tagName = "input")
    List<SelenideElement> inputs;

    @Step
    public void setName(String name) {
        inputs.get(0).sendKeys(name);
    }

    @Step
    public void setEmail(String email) {
        inputs.get(1).sendKeys(email);
    }

    @Step
    public void setPassword(String password) {
        inputs.get(2).sendKeys(password);
    }

    @Step
    public void clickRegisterButton() {
        registrationButton.click();
    }

    //сообщение о некорректности пароля

    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']" )
    SelenideElement massageAboutIncorrectPassword;

    @Step
    public boolean isMassageAboutIncorrectPasswordVisible() {
        return massageAboutIncorrectPassword.isDisplayed();
    }

    //кнопка войти на странице регистрации
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    SelenideElement loginButtonOnRegistrationPage;

    @Step
    public void clickLoginButtonOnRegistrationPage() {
        loginButtonOnRegistrationPage.click();
    }
}
