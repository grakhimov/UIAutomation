package SelenideTasks;

import Pages.Dates;
import Pages.IndexPage;
import Pages.ServiceHeader;
import configs.SelenideExtension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Constants.UserData.USER;
import static Constants.XPositionChange.*;
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
    public void checkSliderOnDatesPage() {
        //open Index page
        open(INDEX_PAGE_URL);

        //login as user and check that user is logged in
        indexPage.login(USER.login, USER.password);
        indexPage.checkUsernameVisibleAndEquals(USER.username);

        //open Dates page
        serviceHeader.openDatesPage();

        //Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.moveLeftSliderAndCheckValue(DEFAULT_TO_0);
        datesPage.moveRightSliderAndCheckValue(DEFAULT_TO_100);

        //Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPage.moveLeftSliderAndCheckValue(FROM_0_TO_0);
        datesPage.moveRightSliderAndCheckValue(FROM_100_TO_0);

        //Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPage.moveRightSliderAndCheckValue(FROM_0_TO_100);
        datesPage.moveLeftSliderAndCheckValue(FROM_0_TO_100);

        //Using drag-and-drop set Range sliders, left - 30, right - 70
        datesPage.moveLeftSliderAndCheckValue(FROM_100_TO_30);
        datesPage.moveRightSliderAndCheckValue(FROM_100_TO_70);
    }
}
