package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class FinishRegistrationBusinessAccountAgreementPage {

    SelenideElement
            agreementCheckbox = $x("//*[@data-testid='field-element-contractSigned']"),
            submitBtn = $x("//*[@type='submit']");

    @Step("Подтверждение ознакомления с соглашением и клик на 'Принять'")
    public FinishRegistrationBusinessAccountVerificationPage agreeWithTermsAndSubmit(){
        agreementCheckbox.should(Condition.exist).click();
        submitBtn.click();
        return new FinishRegistrationBusinessAccountVerificationPage();
    }
}
