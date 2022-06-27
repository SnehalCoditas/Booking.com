package objectrepository;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class HomePage {
    public WebDriver driver;
    public HomePage(WebDriver driver){

        this.driver= driver;

    }

    By place = By.xpath("(//ul[contains(@class,'ia_section-container')])[1]//span[@class='ia_hotelnum']");
    By clickonDate =By.xpath("//div[@class='xp__dates xp__group']");
    By filter = By.xpath("//div[@class='xp__input-group xp__guests']");
    By selectDate = By.xpath("//td[@class='bui-calendar__date']");
    By childCount =By.xpath("//input[@id='group_children']/following-sibling::button[contains(@class,'add')]");
    By searchBox =By.xpath("//button[@class='sb-searchbox__button ']");
    By fiveStarFilter =By.xpath("//span[@class='bb0670bdb4']//div[text()='5 stars']");
    By maxRated =By.xpath("//div[@class='b5cd09854e d10a6220b4']");
    By atm_Dropdown =By.xpath("//select[@name='nr_rooms_270436802_309259302_16_0_0']");



    public void place()
    {
        List<WebElement> regions = driver.findElements(place);
        int maxNoProperty=0;
        WebElement maxProperty=null;

        for(WebElement places: regions){
            String num=places.getText().split(" ")[0];
            while(num.contains(",")){
                String[] arr=num.split(",");
                String str="";
                for(String rem:arr){
                    str=str+rem;
                }
                num=str;
            }
            int value = Integer.parseInt(num);
            if(value>maxNoProperty){
                maxNoProperty=value;
                maxProperty=places;
            }
        }
        driver.findElement(By.xpath("//span[text()='"+maxProperty.getText()+"']/preceding-sibling::a")).click();
    }

    public void click_on_date()
    {
        driver.findElement(clickonDate).click();
        List<WebElement> date = driver.findElements(selectDate);
        javascriptClick(driver,date.get(0));
        javascriptClick(driver,date.get(3));
    }

    public void Filter()
    {
        driver.findElement(filter).click();
    }
    public void child_Count()
    {
        driver.findElement(childCount).click();
    }

    public void search_Box()
    {
        driver.findElement(searchBox).click();
    }
    public void fiveStar_filter() throws InterruptedException {
        Thread.sleep(5000);
        WebElement filter=driver.findElement(fiveStarFilter);
        javascriptClick(driver,filter);
        Thread.sleep(5000);
    }

    public void maxRated_hotel() throws InterruptedException {
        List <WebElement> Score = driver.findElements(maxRated);
        double maxRating =0;
        WebElement maxRatingElement=null;
        for(WebElement rating: Score)
        {
            double value=Double.parseDouble(rating.getText());
            if(value>maxRating){
                maxRating=value;
                maxRatingElement=rating;
            }
        }
        Thread.sleep(5000);
        javascriptClick(driver,maxRatingElement);

        Thread.sleep(10000);

    }

    public void atm_DropDown() throws InterruptedException {
        String parent = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for(String window:windows)
        {
            if(!window.equals(parent))
            {
                driver.switchTo().window(window);
            }
        }

        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement dropdown = driver.findElement(atm_Dropdown);
        js.executeScript("arguments[0].scrollIntoView();", dropdown);
        Thread.sleep(2000);
        Select atmDropdown = new Select(dropdown);
        atmDropdown.selectByValue("1");
    }

    public void javascriptClick(WebDriver driver, WebElement element)
    {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}
