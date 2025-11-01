package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {

    private final SelenideElement
            header = $x("//*[@class='landing-main__title']"),
            usernameInput = $x("//input[@name='username']"),
            emailInput = $x("//input[@name='email']"),
            passwordInput = $x("//input[@name='password']"),
            submitBtn = $x("//button[@type='submit']");

    @Step("Заполнение полей для регистрации")
    public FinishRegistrationPrivateAccountVerificationPage setRegistrationDataAndSubmit(String login, String email, String password){
        usernameInput.setValue(login);
        emailInput.setValue(email);
        passwordInput.setValue(password);
        submitBtn.click();
        return new FinishRegistrationPrivateAccountVerificationPage();
    }

    @Step("Проверка загрузки заголовка страницы")
    public RegistrationPage checkHeader(){
        header.shouldBe(visible);
        return this;
    }
}
