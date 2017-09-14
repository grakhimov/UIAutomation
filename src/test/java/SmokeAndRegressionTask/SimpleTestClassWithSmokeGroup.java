package SmokeAndRegressionTask;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class SimpleTestClassWithSmokeGroup {

    private ChromeDriver chromeDriver = new ChromeDriver();

    @BeforeGroups(groups = {"Smoke"})
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "\\chromedriver.exe");
    }

    @Test(groups = {"Smoke"})
    public void simpleTest1() {
        chromeDriver.navigate().to("https://www.epam.com");
        Assert.assertEquals(chromeDriver.getTitle(),
                "EPAM | Software Product Development Services");
    }

    @Test(groups = {"Smoke"})
    public void simpleTest2() {
        chromeDriver.navigate().to("https://www.epam.com");
        Assert.assertEquals(chromeDriver.getTitle(),
                "EPAM | Software Product Development Services");
    }

    @Test(groups = {"Smoke"})
    public void simpleTest3() {
        chromeDriver.navigate().to("https://www.epam.com");
        Assert.assertEquals(chromeDriver.getTitle(),
                "EPAM | Software Product Development Services");
    }
    @AfterGroups(groups = {"Smoke", "Regression"})
    public void tearDown() {
        chromeDriver.close();
    }
}
