package practikum.pageobjectelements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;

public class ProfilePage {

    //ссылка Зарегистироваться
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Зарегистрироваться')]")
    SelenideElement RegistrationLink;

    public void clickRegistrationLink() {
        this.RegistrationLink.click();
    }

    //кнопка войти
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    SelenideElement LoginButton;

    public boolean isLoginButtonVisible() {
        this.LoginButton.waitUntil(visible, 4000);
        return this.LoginButton.isDisplayed();
    }

    public void loginButtonClick() {
        this.LoginButton.click();
    }

    //поля ввода данных профиля
    @FindBy(tagName = "input")
    List<SelenideElement> inputs;

    public void setEmail(String email) {
        inputs.get(0).sendKeys(email);
    }

    public void setPassword(String password) {
        inputs.get(1).sendKeys(password);
    }

    //ссылка для восстановления пароля
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Восстановить пароль')]")
    SelenideElement RecoverPasswordLink;

    public void clickRecoverPasswordLink() {
        this.RecoverPasswordLink.click();
    }

    //кнопка выйти
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    SelenideElement LogOutButton;

    public void clickLogOutButton() {
        this.LogOutButton.click();
    }
}
