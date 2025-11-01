package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.modals.FinalRegistrationAgreementModal;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FinishRegistrationBusinessAccountVerificationPage {

    private final SelenideElement
            passportFirstPageUploadInput = $x("//input[@id='field-element-passport']"),
            commercialRegisterExtractUploadInput = $x("//input[@id='field-element-commercialRegisterExtract']"),
            certificateOfIncorporationUploadInput = $x("//input[@id='field-element-certificateOfIncorporation']"),
            finishRegistrationBtn = $x("//*[text()='Завершить регистрацию']"),
            passportRequiredError = $x("//*[@data-testid='form-field-passport-error']"),
            commercialRegisterExtractRequiredError = $x("//*[@data-testid='form-field-commercialRegisterExtract-error']"),
            certificateOfIncorporationRequiredError = $x("//*[@data-testid='form-field-certificateOfIncorporation-error']");


    @Step("Клик на 'Завершить регистрацию'")
    public FinalRegistrationAgreementModal finishRegistration(){
        finishRegistrationBtn.click();
        return new FinalRegistrationAgreementModal();
    }

    @Step("Подгрузка обязательных документов")
    public FinishRegistrationBusinessAccountVerificationPage uploadRequiredDocuments(){
        passportFirstPageUploadInput.uploadFromClasspath("pics/img.jpg");
        commercialRegisterExtractUploadInput.uploadFromClasspath("pics/img.jpg");
        certificateOfIncorporationUploadInput.uploadFromClasspath("pics/img.jpg");
        return this;
    }

    @Step("Проверка ошибок валидации при незаполненных обязательных полях")
    public FinishRegistrationBusinessAccountVerificationPage checkValidationErrors(){
        passportRequiredError.should(visible);
        commercialRegisterExtractRequiredError.should(visible);
        certificateOfIncorporationRequiredError.should(visible);
        return this;
    }
}
