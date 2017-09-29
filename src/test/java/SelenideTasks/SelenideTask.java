package SelenideTasks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import configs.SelenideExtension;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.IndexPage;

import static com.codeborne.selenide.Selenide.page;
import static configs.Constans.INDEX_PAGE_URL;
import static configs.Constans.PASSWORD;
import static configs.Constans.USERNAME;

public class SelenideTask extends SelenideExtension {
    private ChromeDriver chromeDriver;
    private IndexPage indexPage;

    @BeforeClass
    public void selenideConfiguration() {
        Configuration.browser = "CHROME";
        Configuration.startMaximized = true;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "build/reports/tests";
        chromeDriver = new ChromeDriver();
        indexPage = page(IndexPage.class);
    }

    @Test
    public void task1() {
        Selenide.open(INDEX_PAGE_URL);
        indexPage.login(USERNAME, PASSWORD);
        //indexPage.checkMainTexts();

        //indexPageElementsAreExist();*/
    }
}
