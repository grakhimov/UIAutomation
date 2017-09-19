package AnnotationTask;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestClassWithAllAnnotationTypesTask {
    public ChromeDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUpTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeClass
    public void setUpClass() {
        ChromeDriver driver = new ChromeDriver();
    }

    @BeforeSuite
    public void setUpSuite() {
        System.out.println(driver.getTitle());
    }

    @Test
    public void simpleTest() {
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println(System.currentTimeMillis());
    }

    @AfterSuite
    public void tearDownSuite() {
        driver.close();
    }

    @AfterTest
    public void tearDownTest() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }
}
