package MainPageWithDataProviderTask;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainPageWithDataProvider {
    private ChromeDriver chromeDriver = new ChromeDriver();

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @DataProvider(parallel = true)
    public Object[][] procs() {
        return new Object[][]{{1, "To include good practices"}, {2, "To be flexible and customizable"},
                {3, "To be multiplatform"}, {4, "Already have good base(about 20 internal and some external projects) wish to get more…"}};
    }

    @Test(dataProvider = "procs")
    public void getProcs(int position, String proc) {
        //Open main page
        chromeDriver.navigate().to("https://jdi-framework.github.io/tests");
        chromeDriver.manage().window().maximize();
        chromeDriver.findElement(By.cssSelector((".benefits"))).getText().contains(proc);
    }

    @AfterClass
    public void tearDown() {
        chromeDriver.close();
    }
}
