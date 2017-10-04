package CucumberTask;

import cucumber.api.java.en.Given;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static configs.Constans.INDEX_PAGE_TITLE;
import static configs.Constans.INDEX_PAGE_URL;

public class CucumberSteps {
    @Given("^Website is opened$")
    public void openWebsite() {
        open(INDEX_PAGE_URL);
        title().contains(INDEX_PAGE_TITLE);
    }

    @Test
    public void start() {
        openWebsite();
    }
}
