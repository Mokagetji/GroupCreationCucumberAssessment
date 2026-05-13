package Steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class stepsDefinition {

    WebDriver driver;

    @Before
    public void setup(){
        driver = new EdgeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();

    }

    @Given("i am ndosi automation homepage")
    public void i_am_ndosi_automation_homepage() {
        assert driver.findElement(By.id("overview-section")).isDisplayed();

    }
    @And("i click login button")
    public void i_click_login_button() {
        driver.findElement(By.xpath("//button[.//span[contains(text(),'Login')]]")).click();

    }
    @When("i am on the login page")
    public void i_am_on_the_login_page() {
        assert driver.findElement(By.id("login-card")).isDisplayed();

    }
    @And("i enter admin email (.*)$")
    public void i_enter_admin_email(String email) {
        driver.findElement(By.id("login-email")).sendKeys(email);

    }
    @And("i enter admin password (.*)$")
    public void i_enter_admin_password(String password) {
        driver.findElement(By.id("login-password")).sendKeys(password);

    }
    @And("i click login submit button")
    public void i_click_login_submit_button() {
        driver.findElement(By.id("login-submit")).click();

    }
    @Then("i should be logged in successfully as admin")
    public void i_should_be_logged_in_successfully_as_admin() {
        assert driver.findElement(By.id("app-main-content")).isDisplayed();


    }



}
