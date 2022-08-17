package practikum.pageobjectelements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RecoverPasswordPage {

    //кнопка войти на странице восстановления пароля
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    SelenideElement loginButtonOnRecoverPasswordPage;

    @Step
    public void clickLoginButtonOnRecoverPasswordPage() {
        loginButtonOnRecoverPasswordPage.click();
    }
}
