package objectrepository;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public HomePage Home_Page;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver){
        this.driver =driver;
    }

    public HomePage getHomePage()
    {
        Home_Page =new HomePage(driver);
        return Home_Page;

    }
}
