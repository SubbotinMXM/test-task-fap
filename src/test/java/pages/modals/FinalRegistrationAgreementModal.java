package pages.modals;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class FinalRegistrationAgreementModal {

    SelenideElement refuseBtn = $x("//*[@data-testid='affidavit-modal__cancel']");

    @Step("Клик на 'Отказаться и удалить мой контент'")
    public RefuseAndDeleteContentModal refuseAndDeleteContent(){
        refuseBtn.click();
        return new RefuseAndDeleteContentModal();
    }
}
