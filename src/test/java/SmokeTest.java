import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest {
    @Test
    public void smokeTest() {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://jdi-framework.github.io/tests");
        Assert.assertEquals(chromeDriver.getTitle(), "Index Page");
        chromeDriver.manage().window().maximize();
        chromeDriver.findElement(By.xpath("//a[@href=\"#\"]")).click();
        chromeDriver.findElement(By.xpath("//input[@id=\"Login\"]")).sendKeys("epam");
        chromeDriver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("1234");
        chromeDriver.findElement(By.xpath("//form/button")).click();
        Assert.assertEquals(chromeDriver.findElement(By.xpath("//a[@href=\"#\"]")).getText(), "PITER CHAILOVSKII");
        chromeDriver.findElement(By.xpath("//a[text()=\"Contact form\"]")).click();
        Assert.assertEquals(chromeDriver.getTitle(), "Contact Form");
        chromeDriver.findElement(By.xpath("//input[@id=\"Name\"]")).sendKeys("George");
        chromeDriver.findElement(By.xpath("//input[@id=\"LastName\"]")).sendKeys("Rakhimov");
        chromeDriver.findElement(By.xpath("//div[@class=\"info-panel-body info-panel-body-log\"]")).getText().contains("submit");
        chromeDriver.close();
    }
}
