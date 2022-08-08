package practikum.pageobjectelements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RecoverPasswordPage {

    //кнопка войти на странице восстановления пароля
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    SelenideElement LoginButtonOnRecoverPasswordPage;

    public void clickLoginButtonOnRecoverPasswordPage() {
        this.LoginButtonOnRecoverPasswordPage.click();
    }
}
