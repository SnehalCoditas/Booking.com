package utils;

import objectrepository.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class TextContextSetup {

    public  WebDriver driver;
    public PageObjectManager pageObjectManager;
    public BaseClass baseClass;

    public TextContextSetup()
    {
        baseClass = new BaseClass();
        pageObjectManager= new PageObjectManager(baseClass.WebDriverManager());
    }
}
