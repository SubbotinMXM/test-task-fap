package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class FinishRegistrationPrivateAccountVerificationPage {

    SelenideElement
            businessAccountTypeBtn = $x("//*[text()='Бизнес']");

    @Step("Переключение на тип аккаунта 'Бизнес'")
    public FinishRegistrationBusinessAccountDescriptionPage switchToBusinessAccount(){
        Selenide.sleep(10_000);
        businessAccountTypeBtn.click();
        return new FinishRegistrationBusinessAccountDescriptionPage();
    }
}
