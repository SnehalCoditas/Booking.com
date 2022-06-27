package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class HomePage {
    public WebDriver driver;
    public HomePage(WebDriver driver){

        this.driver= driver;

    }

    By places = By.partialLinkText("England");
    By clickonDate =By.xpath("//div[@class='xp__dates xp__group']");
    By filter = By.xpath("//div[@class='xp__input-group xp__guests']");
    By selectDate = By.xpath("//td[@class='bui-calendar__date']");
    By childCount =By.xpath("//input[@id='group_children']/following-sibling::button[contains(@class,'add')]");
    By searchBox =By.xpath("//button[@class='sb-searchbox__button ']");
    By fiveStarFilter =By.xpath("//span[@class='bb0670bdb4']//div[text()='5 stars']");
    By maxRated =By.xpath("//div[@class='b5cd09854e d10a6220b4']");



    public void place()
    {
        driver.findElement(places).click();
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
        driver.close();
    }


    public void javascriptClick(WebDriver driver, WebElement element)
    {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}
