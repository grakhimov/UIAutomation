package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static configs.Constans.*;

public abstract class IndexPage implements SelenideElement {

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

    @FindBy(css = ".benefit")
    private ElementsCollection textsUnderPictures;

    //Open test site by URL
    public IndexPage() {
        open(INDEX_PAGE_TITLE);
    }

    //Perform login
    public void login(String username, String password) {
        loginForm.click();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        enterButton.click();
    }

    //check that user is logged in
    public void checkUsernameVisibleAndEquals(String username) {
        profileUsername.shouldBe(visible);
        profileUsername.shouldHave(exactText(username));
    }

    //Check interface on Home page, it contains all expected elements.
    public void checkInterface() {
        checkPicsArePresent();
        checkTextsUnderPics();
        checkMainTexts();
    }

    //Check that 4 pictures are present
    public void checkPicsArePresent() {
        iconPractise.shouldBe(visible);
        iconCustom.shouldBe(visible);
        iconMulti.shouldBe(visible);
        iconBase.shouldBe(visible);
    }

    //Check 4 texts under 4 pictures
    public void checkTextsUnderPics() {
        textsUnderPictures.shouldHave(exactTexts(BENEFIT_BASE, BENEFIT_CUSTOM, BENEFIT_MULTI, BENEFIT_PRACTICE));
    }

    //Check texts above pictures
    public void checkMainTexts() {
        mainTitle.shouldHave(exactText(INDEX_PAGE_MAIN_TITLE));
        mainText.shouldHave(exactText(INDEX_PAGE_MAIN_TEXT));
    }
}

