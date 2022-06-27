package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    public WebDriver driver;

    public WebDriver WebDriverManager()
    {
        if(driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.booking.com/");
            driver.manage().window().maximize();
        }
        return driver;
    }
}
