package pages.modals;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class RefuseAndDeleteContentModal {

    SelenideElement deleteBtn = $x("//*[@data-testid='affidavit-dismiss-modal__ok']");

    @Step("Клик на 'Удалить'")
    public RegistrationPage delete(){
        Selenide.sleep(2000);
        deleteBtn.click();
        return new RegistrationPage();
    }
}
