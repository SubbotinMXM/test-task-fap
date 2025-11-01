package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FinishRegistrationBusinessAccountDescriptionPage {
    Faker faker = new Faker();

    SelenideElement
            producerNameInput = $x("//*[@data-testid='field-element-producerName']"),
            contactFirstnameInput = $x("//*[@data-testid='field-element-contactFirstname']"),
            contactLastnameInput = $x("//*[@data-testid='field-element-contactLastname']"),
            directorFirstnameInput = $x("//*[@data-testid='field-element-directorFirstname']"),
            directorLastnameInput = $x("//*[@data-testid='field-element-directorLastname']"),
            companyNameInput = $x("//*[@data-testid='field-element-companyName']"),
            registrationNumberInput = $x("//*[@data-testid='field-element-registrationNumber']"),
            addressCountryCodeDropdown = $x("//div[@data-testid='field-element-addressCountryCode']"),
            addressCountryCodeInput = $x("//input[@data-testid='field-element-addressCountryCode']"),
            addressCityInput = $x("//*[@data-testid='field-element-addressCity']"),
            addressRegionInput = $x("//*[@data-testid='field-element-addressRegion']"),
            addressPostCodeInput = $x("//*[@data-testid='field-element-addressPostCode']"),
            addressStreetInput = $x("//*[@data-testid='field-element-addressStreet']"),
            custodianOfRecordsAddressInput = $x("//*[@data-testid='field-element-custodianOfRecordsAddress']"),
            submitBtn = $x("//*[@data-testid='wizard-business-form-submit-btn']");

    ElementsCollection
            addressCountryCodeDropdownCollection = $$x("//div[@data-testid='field-element-addressCountryCode']//li");

    @Step("Заполнение обязательных полей и клик на 'Вперед'")
    public FinishRegistrationBusinessAccountAgreementPage fillRequiredDataAndSubmit(){
        producerNameInput.setValue(faker.name().firstName() + faker.name().firstName());
        contactFirstnameInput.setValue(faker.name().firstName());
        contactLastnameInput.setValue(faker.name().lastName());
        directorFirstnameInput.setValue(faker.name().firstName());
        directorLastnameInput.setValue(faker.name().lastName());
        directorLastnameInput.setValue(faker.name().lastName());
        companyNameInput.setValue(faker.company().name());
        registrationNumberInput.setValue(faker.address().zipCode());
        selectRandomCountry();
        addressCityInput.setValue(faker.address().city());
        addressRegionInput.setValue(faker.address().state());
        addressPostCodeInput.setValue(faker.address().zipCode());
        addressStreetInput.setValue(faker.address().streetAddress());
        custodianOfRecordsAddressInput.setValue(faker.address().streetAddress());
        submitBtn.click();
        return new FinishRegistrationBusinessAccountAgreementPage();
    }

    @Step("Выбор случайной страны")
    private void selectRandomCountry(){
        custodianOfRecordsAddressInput.scrollIntoView(false);
        addressCountryCodeDropdown.click();
        var randomCountry = addressCountryCodeDropdownCollection.get(faker.number()
                .numberBetween(0, addressCountryCodeDropdownCollection.size()));
        String countryName = randomCountry.getAttribute("textContent");
        addressCountryCodeInput.setValue(countryName);
        $x("//button[text()='" + countryName + "']").click();
    }
}
