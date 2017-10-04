package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static configs.Constans.*;

public class IndexPage {

    @FindBy(css = ".fa-user")
    private SelenideElement loginForm;

    @FindBy(css = "#Login")
    private SelenideElement usernameField;

    @FindBy(css = "#Password")
    private SelenideElement passwordField;

    @FindBy(css = ".fa-sign-in")
    private SelenideElement enterButton;

    @FindBy(css = ".profile-photo span")
    private SelenideElement profileUsername;

    @FindBy(css = ".icon-practise")
    private SelenideElement iconPractise;

    @FindBy(css = ".icon-custom")
    private SelenideElement iconCustom;

    @FindBy(css = ".icon-multi")
    private SelenideElement iconMulti;

    @FindBy(css = ".icon-base")
    private SelenideElement iconBase;

    @FindBy(css = ".main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textsUnderPictures;

    @Step
    //Perform login
    public void login(String username, String password) {
        loginForm.click();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        enterButton.click();
    }

    @Step
    //check that user is logged in
    public void checkUsernameVisibleAndEquals(String username) {
        profileUsername.shouldBe(visible);
        profileUsername.shouldHave(exactText(username));
    }

    @Step
    //Check interface on Home page, it contains all expected elements.
    public void checkInterface() {
        checkPageTitle();
        checkPicsArePresent();
        checkTextsUnderPics();
        checkMainTexts();
    }

    @Step
    //Check that 4 pictures are present
    private void checkPicsArePresent() {
        iconPractise.shouldBe(visible);
        iconCustom.shouldBe(visible);
        iconMulti.shouldBe(visible);
        iconBase.shouldBe(visible);
    }

    @Step
    //Check 4 texts under 4 pictures
    private void checkTextsUnderPics() {
        textsUnderPictures.shouldHave(exactTexts(BENEFIT_PRACTICE, BENEFIT_CUSTOM, BENEFIT_MULTI, BENEFIT_BASE));
    }

    @Step
    //Check texts above pictures
    private void checkMainTexts() {
        mainTitle.shouldHave(exactText(INDEX_PAGE_MAIN_TITLE));
        mainText.shouldHave(exactText(INDEX_PAGE_MAIN_TEXT));
    }

    //Check page title

    @Step
    private void checkPageTitle() {
        Selenide.title().contains(INDEX_PAGE_TITLE);
    }
}

