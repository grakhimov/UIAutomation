package MainPageAndContactFormTask;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainPageAndContactForm {

    public static ChromeDriver chromeDriver = new ChromeDriver();

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "\\chromedriver.exe");
    }
    @Test
    public void oneningMainPageAndLogIn() {
        //Open main page
        chromeDriver.navigate().to("https://jdi-framework.github.io/tests");
        Assert.assertEquals(chromeDriver.getTitle(), "Index Page"); //Browser title equals "Index page"
        chromeDriver.manage().window().maximize();
        //Open login form and fill it with credentials
        chromeDriver.findElement(By.xpath("//a[@href=\"#\"]")).click();
        chromeDriver.findElement(By.xpath("//input[@id=\"Login\"]")).sendKeys("epam");
        chromeDriver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("1234");
        chromeDriver.findElement(By.xpath("//form/button")).click(); //User has loggined
        //Verify that login is successful
        Assert.assertEquals(chromeDriver.findElement(By.xpath("//a[@href=\"#\"]")).getText(), "PITER CHAILOVSKII"); //Name has displayed and equals to expected result
    }
    @Test
    public void openingContactFormAndSendingRequest(){
        //Open Contact form and send request
        chromeDriver.findElement(By.xpath("//a[text()=\"Contact form\"]")).click();
        Assert.assertEquals(chromeDriver.getTitle(), "Contact Form"); //Contact form has opened
        chromeDriver.findElement(By.xpath("//input[@id=\"Name\"]")).sendKeys("George");
        chromeDriver.findElement(By.xpath("//input[@id=\"LastName\"]")).sendKeys("Rakhimov");
        chromeDriver.findElement(By.xpath("//div[@class=\"info-panel-body info-panel-body-log\"]")).getText().contains("submit"); //In the log section a new raw has displayed which contains text "submit"
    }
    @AfterClass
    public void tearDown(){
        chromeDriver.close();
    }
}
