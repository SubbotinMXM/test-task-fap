package tests;

import annotation.RandomUser;
import annotation.meta.WebTest;
import model.UserData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


import static com.codeborne.selenide.Selenide.open;
import static config.Config.getConfig;


@WebTest
@Tag("WebTests")
public class Tests extends TestBase {

    @Test
    @DisplayName("Негативный тест на регистрацию")
    void registrationNegativeTest(@RandomUser UserData userData) {
        open(getConfig().baseUrl(), RegistrationPage.class)
                .setRegistrationDataAndSubmit(userData.getFirstName(), userData.getEmail(), userData.getPassword())
                .switchToBusinessAccount()
                .fillRequiredDataAndSubmit()
                .agreeWithTermsAndSubmit()
                .finishRegistration();
        finishRegistrationBusinessAccountVerificationPage.checkValidationErrors();
    }

    @Test
    @DisplayName("Позитивный тест на регистрацию")
    void registrationPositiveTest(@RandomUser UserData userData) {
        open(getConfig().baseUrl(), RegistrationPage.class)
                .setRegistrationDataAndSubmit(userData.getFirstName(), userData.getEmail(), userData.getPassword())
                .switchToBusinessAccount()
                .fillRequiredDataAndSubmit()
                .agreeWithTermsAndSubmit()
                .uploadRequiredDocuments()
                .finishRegistration()
                .refuseAndDeleteContent()
                .delete()
                .checkHeader();
    }

}