package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class FinishRegistrationPage {

    SelenideElement
            businessAccountTypeBtn = $x("//*[text()='Бизнес']");

    @Step("Переключение на тип аккаунта 'Бизнес'")
    public FinishRegistrationBusinessAccountDescriptionPage switchToBusinessAccount(){
        Selenide.sleep(7000);
        businessAccountTypeBtn.click();
        return new FinishRegistrationBusinessAccountDescriptionPage();
    }
}
