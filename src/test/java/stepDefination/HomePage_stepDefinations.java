package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectrepository.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TextContextSetup;

import java.util.List;

public class HomePage_stepDefinations {

    public TextContextSetup textContextSetup;


    public HomePage_stepDefinations(TextContextSetup textContextSetup){
        this.textContextSetup = textContextSetup;

    }

    @Given("^User opens the browser$")
    public void user_opens_the_browser() throws Throwable {
        textContextSetup.baseClass.WebDriverManager();
    }

    @When("^User select the place England$")
    public void user_select_the_place_england() throws Throwable {
        HomePage Home_Page= textContextSetup.pageObjectManager.getHomePage();
        Home_Page.place();
    }

    @Then("^Selects Checkin and checkout date with selection of child filter$")
    public void selects_checkin_and_checkout_date_with_selection_of_child_filter() throws Throwable {
        HomePage Home_Page= textContextSetup.pageObjectManager.getHomePage();
        Home_Page.click_on_date();
        Home_Page.Filter();
        Home_Page.child_Count();
    }

    @And("^User Selects on Search$")
    public void user_selects_on_search() throws Throwable {
        HomePage Home_Page= textContextSetup.pageObjectManager.getHomePage();
        Home_Page.search_Box();

    }

    @And("^User applies 5 star filter$")
    public void user_applies_5_star_filter() throws Throwable {
        HomePage Home_Page= textContextSetup.pageObjectManager.getHomePage();
        Home_Page.fiveStar_filter();

    }

    @And("^User selects highest rated hotel$")
    public void user_selects_highest_rated_hotel() throws Throwable {
        HomePage Home_Page= textContextSetup.pageObjectManager.getHomePage();
        Home_Page.maxRated_hotel();
    }
    @And("^click on amount dropdrop and click$")
    public void click_on_amount_dropdrop_and_click() throws Throwable {
        HomePage Home_Page= textContextSetup.pageObjectManager.getHomePage();
        Home_Page.atm_DropDown();
        Home_Page.takeScreenshot("ScreenShot");

    }

}
