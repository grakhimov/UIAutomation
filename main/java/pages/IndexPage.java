package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static configs.Constans.*;
import static org.junit.Assert.assertEquals;

public class IndexPage {
    private static SelenideElement loginForm = $(".fa-user");
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
    private static SelenideElement textBaseOnIndexPage = $(By.xpath("//div[@class=\"col-sm-3\"][4]/div"));

    @BeforeClass
    public static void selenideConfiguration() {
        Configuration.browser = "CHROME";
        Configuration.startMaximized = true;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "build/reports/tests";
    }

    @AfterClass
    public static void tearDown() {
    }

    @Test
    public static void openIndexPage() {
        open("https://jdi-framework.github.io/tests/index.htm");
        assertEquals(title(), INDEX_PAGE);
    }

    @Test
    public static void login() {
        loginForm.click();
        usernameInput.sendKeys(USERNAME);
        passwordInput.sendKeys(PASSWORD);
        loginButton.click();
        logoutButton.isDisplayed();
        profileDropdown.shouldHave(text(LOGGED_USERNAME));
    }

    @Test
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
    }
}
