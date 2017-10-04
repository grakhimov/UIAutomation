package Pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static Constants.Service.*;

public class ServiceLeftSection {
    @FindBy(css = ".sub-menu > a")
    private SelenideElement dropdownService;

    @FindBy(css = ".sub span")
    private ElementsCollection menuService;

    @Step
    //Click on "ServiceHeader" subcategory in the header and check that drop down contains options
    public void checkDropdownMenuContainsNeccessaryElements() {
        dropdownService.click();
        menuService.shouldHave(CollectionCondition.exactTexts(SUPPORT.text, DATES.text, COMPLEX_TABLE.text, SIMPLE_TABLE.text, TABLE_WITH_PAGES.text, DIFFERENT_ELEMENTS.text));
    }
}
