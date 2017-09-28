package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static configs.Constans.INDEX_PAGE;
import static org.junit.Assert.assertEquals;

public abstract class IndexPage implements SelenideElement {

    @FindBy(css = ".fa-user")
    String loginForm;

    /*private static SelenideElement loginForm = $(".fa-user");
    private static SelenideElement usernameInput = $("#Login");
    private static SelenideElement passwordInput = $("#Password");
    private static SelenideElement loginButton = $(".fa-sign-in");
    private static SelenideElement logoutButton = $(".fa-sign-out");
    private static SelenideElement profileDropdown = $(".profile-photo");
    private static SelenideElement titleOfMainTextOnIndexPage = $(".main-title");
    private static SelenideElement mainTextOnIndexPage = $(".main-txt");
    private static SelenideElement iconPracticeOnIndexPage = $(".icon-practise");
    private static SelenideElement iconCustomOnIndexPage = $(".icon-custom");
    private static SelenideElement iconMultiOnIndexPage = $(".icon-multi");
    private static SelenideElement iconBaseOnIndexPage = $(".icon-base");
    private static SelenideElement textPracticeOnIndexPage = $(By.xpath("//div[@class=\"col-sm-3\"][1]/div"));
    private static SelenideElement textCustomOnIndexPage = $(By.xpath("//div[@class=\"col-sm-3\"][2]/div"));
    private static SelenideElement textMultiOnIndexPage = $(By.xpath("//div[@class=\"col-sm-3\"][3]/div"));
    private static SelenideElement textBaseOnIndexPage = $(By.xpath("//div[@class=\"col-sm-3\"][4]/div"));*/

    @AfterClass
    public static void tearDown() {
    }

    @Test
    public void openIndexPage() {
        open("https://jdi-framework.github.io/tests/index.htm");
        assertEquals(title(), INDEX_PAGE);
    }

    @Test
    public void login() {
        $(loginForm).click();
        /*usernameInput.sendKeys(USERNAME);
        passwordInput.sendKeys(PASSWORD);
        loginButton.click();
        logoutButton.isDisplayed();
        profileDropdown.shouldHave(text(LOGGED_USERNAME));*/
    }

    /*@Test
    public static void indexPageElementsAreExist() {
        titleOfMainTextOnIndexPage.exists();
        mainTextOnIndexPage.exists();
        iconPracticeOnIndexPage.exists();
        iconCustomOnIndexPage.exists();
        iconMultiOnIndexPage.exists();
        iconBaseOnIndexPage.exists();
        textPracticeOnIndexPage.exists();
        textCustomOnIndexPage.exists();
        textMultiOnIndexPage.exists();
        textBaseOnIndexPage.exists();
    }*/
}
