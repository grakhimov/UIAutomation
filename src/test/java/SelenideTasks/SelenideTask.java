package SelenideTasks;

import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

public class SelenideTask {

    @BeforeClass
    public static void selenideConfiguration() {
        Configuration.browser = "CHROME";
        Configuration.startMaximized = true;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "build/reports/tests";
    }
    @Test
    public void task1() {
        //openIndexPage();
        /*login();
        indexPageElementsAreExist();*/
    }
}
