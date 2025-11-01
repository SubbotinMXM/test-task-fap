package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.Config;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import pages.FinishRegistrationBusinessAccountVerificationPage;
import pages.modals.FinalRegistrationAgreementModal;

public class TestBase {

    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = Config.getConfig().browserSize();
        Configuration.browser = Config.getConfig().browser();
        Configuration.headless = Config.getConfig().headless();
        Configuration.timeout = 30_000;
        Configuration.pageLoadTimeout = 30_000;
        Configuration.pageLoadStrategy = "eager";
    }

    FinishRegistrationBusinessAccountVerificationPage finishRegistrationBusinessAccountVerificationPage =
            new FinishRegistrationBusinessAccountVerificationPage();
}
