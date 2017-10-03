package SelenideTasks;

import Pages.DifferentElementsPage;
import Pages.IndexPage;
import Pages.ServiceHeader;
import Pages.ServiceLeftSection;
import configs.SelenideExtension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Constants.Checkboxes.WATER;
import static Constants.Checkboxes.WIND;
import static Constants.DropdownValues.YELLOW;
import static Constants.Radios.SELEN;
import static Constants.UserData.USER;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static configs.Constans.INDEX_PAGE_URL;

public class SelenideTask extends SelenideExtension {
    private IndexPage indexPage;
    private ServiceHeader serviceHeader;
    private ServiceLeftSection serviceLeftSection;
    private DifferentElementsPage differentElementsPage;

    @BeforeMethod
    public void selenideConfiguration() {
        indexPage = page(IndexPage.class);
        serviceHeader = page(ServiceHeader.class);
        serviceLeftSection = page(ServiceLeftSection.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @Test
    public void checkIndexAndDiffElementsPage() {
        //open Index page
        open(INDEX_PAGE_URL);

        //login as user and check that user is logged in
        indexPage.login(USER.login, USER.password);
        indexPage.checkUsernameVisibleAndEquals(USER.username);

        //check index page interface
        indexPage.checkInterface();

        //check header Service items
        serviceHeader.checkDropdownMenuContainsNecessaryElements();

        //check Service dropdown on left side items
        serviceLeftSection.checkDropdownMenuContainsNeccessaryElements();

        //open Different Elements page and check it's interface
        serviceHeader.openDifferentElementsPage();
        differentElementsPage.checkInterface();

        //set checkboxes
        differentElementsPage.selectCheckbox(WATER);
        differentElementsPage.selectCheckbox(WIND);

        //set radiobutton
        differentElementsPage.selectRadio(SELEN);

        //select value in dropdown
        differentElementsPage.selectInDropdown(YELLOW);

        //check log section
        differentElementsPage.checkLogs(WATER.text, "true");
        differentElementsPage.checkLogs(WIND.text, "true");
        differentElementsPage.checkLogs("metal", SELEN.text);
        differentElementsPage.checkLogs("Colors", YELLOW.text);

        //unset checkboxes
        differentElementsPage.uncheckCheckbox(WATER);
        differentElementsPage.uncheckCheckbox(WIND);

        //check log section
        differentElementsPage.checkLogs(WATER.text, "false");
        differentElementsPage.checkLogs(WIND.text, "false");
    }
}
