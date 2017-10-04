package SelenideTasks;

import Pages.Dates;
import Pages.IndexPage;
import Pages.ServiceHeader;
import configs.SelenideExtension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Constants.UserData.USER;
import static Constants.XPositionChange.DEFAULT_TO_0;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static configs.Constans.INDEX_PAGE_URL;

public class SliderActions extends SelenideExtension {
    private IndexPage indexPage;
    private ServiceHeader serviceHeader;
    private Dates datesPage;

    @BeforeMethod
    public void selenideConfiguration() {
        indexPage = page(IndexPage.class);
        serviceHeader = page(ServiceHeader.class);
        datesPage = page(Dates.class);
    }

    @Test
    public void checkIndexAndDiffElementsPage() {
        //open Index page
        open(INDEX_PAGE_URL);

        //login as user and check that user is logged in
        indexPage.login(USER.login, USER.password);
        indexPage.checkUsernameVisibleAndEquals(USER.username);

        serviceHeader.openDatesPage();

        datesPage.moveLeftSliderAndCheckValue(DEFAULT_TO_0);
        datesPage.moveRightSliderAndCheckValue();

    }
}
