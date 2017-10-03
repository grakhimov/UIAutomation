package Pages;

import Constants.Checkboxes;
import Constants.DropdownValues;
import Constants.Radios;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static Constants.Checkboxes.*;
import static Constants.Radios.*;
import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class DifferentElementsPage {

    @FindBy(css = "input[type=\"checkbox\"]")
    private ElementsCollection checkboxes;

    @FindBy(css = ".checkbox-row .label-checkbox")
    private ElementsCollection checkboxesLabels;

    @FindBy(css = "input[type=\"radio\"]")
    private ElementsCollection radios;

    @FindBy(css = ".checkbox-row .label-radio")
    private ElementsCollection radiosLabels;

    @FindBy(css = ".colors .uui-form-element")
    private SelenideElement colorDropdown;

    @FindBy(css = ".colors .uui-form-element option")
    private ElementsCollection colorDropdownValues;

    @FindBy(css = ".uui-button[value=\"Default Button\"]")
    private SelenideElement defaultButton;

    @FindBy(css = ".uui-button[value=\"Button\"]")
    private SelenideElement button;

    @FindBy(css = ".info-panel-body-log ul")
    private SelenideElement infoPanelLog;

    @FindBy(css = "#mCSB_1")
    private SelenideElement leftSection;

    @FindBy(css = "#mCSB_2")
    private SelenideElement rightSection;

    public void checkInterface() {
        colorDropdown.shouldBe(visible);
        defaultButton.shouldBe(visible);
        button.shouldBe(visible);
        infoPanelLog.shouldBe(visible);
        leftSection.shouldBe(visible);
        rightSection.shouldBe(visible);

        for (SelenideElement checkbox : checkboxes) {
            checkbox.shouldBe(visible);
        }

        checkboxesLabels.shouldHave(exactTexts(WATER.text, EARTH.text, WIND.text, FIRE.text));

        for (SelenideElement radio : radios) {
            radio.shouldBe(visible);
        }

        radiosLabels.shouldHave(exactTexts(GOLD.text, SILVER.text, BRONZE.text, SELEN.text));

        colorDropdown.click();
        for (DropdownValues value : DropdownValues.values()) {
            colorDropdownValues.get(value.ordinal()).shouldBe(matchesText(value.text));
        }
        colorDropdown.click();

    }

    public void selectCheckbox(Checkboxes checkbox) {
        checkboxes.get(checkbox.ordinal()).click();
        checkboxes.get(checkbox.ordinal()).shouldBe(checked);
    }

    public void selectRadio(Radios radio) {
        radios.get(radio.ordinal()).click();
        radios.get(radio.ordinal()).shouldBe(checked);
    }

    public void selectInDropdown(DropdownValues dropdownValue) {
        colorDropdown.click();
        colorDropdownValues.get(dropdownValue.ordinal()).click();
        colorDropdown.shouldHave(text(dropdownValue.text));
    }

    public void checkLogs(String text, String condition) {
        ElementsCollection rowsInfoPanelLog = $$(".info-panel-body-log ul li");
        rowsInfoPanelLog.find(matchesText(text)).should(matchesText(condition));
    }

    public void uncheckCheckbox(Checkboxes checkbox) {
        if (checkboxes.get(checkbox.ordinal()).is(checked)) {
            checkboxes.get(checkbox.ordinal()).click();
            checkboxes.get(checkbox.ordinal()).shouldNotBe(checked);
        }
    }
}
