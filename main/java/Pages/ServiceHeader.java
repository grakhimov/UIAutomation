package Pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static Constants.Service.*;
import static com.codeborne.selenide.Selenide.title;

public class ServiceHeader {
    @FindBy(css = ".dropdown>a[href=\"page1.htm\"]")
    private SelenideElement dropdownService;

    @FindBy(css = ".dropdown-menu li")
    private ElementsCollection menuService;

    //Click on "ServiceHeader" subcategory in the header and check that drop down contains options
    public void checkDropdownMenuContainsNecessaryElements() {
        dropdownService.click();
        menuService.shouldHave(CollectionCondition.exactTexts(SUPPORT.text, DATES.text, COMPLEX_TABLE.text, SIMPLE_TABLE.text, TABLE_WITH_PAGES.text, DIFFERENT_ELEMENTS.text));
    }

    public void openDifferentElementsPage() {
        dropdownService.click();
        menuService.get(DIFFERENT_ELEMENTS.ordinal()).click();
        title().contains(DIFFERENT_ELEMENTS.text);
    }
}
