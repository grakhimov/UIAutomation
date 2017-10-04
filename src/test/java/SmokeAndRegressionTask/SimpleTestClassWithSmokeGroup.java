package SmokeAndRegressionTask;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class SimpleTestClassWithSmokeGroup {

    private ChromeDriver chromeDriver;
    private ChromeOptions options;

    @BeforeGroups(groups = {"Smoke"})
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\GEUK\\UIAutomation\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--start-maximized --no-sandbox --disable-extensions");
    }

    @Test(groups = {"Smoke"})
    public void simpleTest1() {
        chromeDriver = new ChromeDriver(options);

        chromeDriver.navigate().to("https://www.epam.com");
        Assert.assertEquals(chromeDriver.getTitle(),
                "EPAM | Software Product Development Services");

        chromeDriver.close();
    }

    @Test(groups = {"Smoke"})
    public void simpleTest2() {
        chromeDriver = new ChromeDriver(options);

        chromeDriver.navigate().to("https://www.epam.com");
        Assert.assertEquals(chromeDriver.getTitle(),
                "EPAM | Software Product Development Services");

        chromeDriver.close();
    }

    @Test(groups = {"Smoke"})
    public void simpleTest3() {
        chromeDriver = new ChromeDriver(options);

        chromeDriver.navigate().to("https://www.epam.com");
        Assert.assertEquals(chromeDriver.getTitle(),
                "EPAM | Software Product Development Services");

        chromeDriver.close();
    }
}
