package configs;

import com.codeborne.selenide.Configuration;

public abstract class SelenideExtension {
    public SelenideExtension() {
        Configuration.browser = "CHROME";
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Configuration.startMaximized = true;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "build/reports/tests";
    }
}
