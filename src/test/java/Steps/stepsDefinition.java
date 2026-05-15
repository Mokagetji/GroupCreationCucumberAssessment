package Steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
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
    public void i_click_login_submit_button() throws InterruptedException {
        driver.findElement(By.id("login-submit")).click();
        //driver.wait(5000);

    }
    @Then("i should be logged in successfully as admin")
    public void i_should_be_logged_in_successfully_as_admin() throws InterruptedException {
        assert driver.findElement(By.id("app-main-content")).isDisplayed();
        Thread.sleep(5000);

    }
    @When("i click on the profile button")
    public void i_click_on_the_profile_button() throws InterruptedException {
                driver.findElement(By.xpath("//button[contains(@class,'user-pill')]")).click();
                Thread.sleep(5000);
    }
    @And("i click admin panel")
    public void i_click_admin_panel() throws InterruptedException {
        driver.findElement(By.xpath("//button[.//span[contains(text(),'Admin')]]")).click();
        Thread.sleep(5000);
    }
    @Then("i should be redirected to admin dashboard")
    public void i_should_be_redirected_to_admin_dashboard() {
       assert driver.findElement(By.xpath("//div[@class='admin-dashboard']")).isDisplayed();
    }

    @When("i click groups")
    public void i_click_groups() throws InterruptedException {
        driver.findElement(By.xpath("//nav//button[contains(.,'Groups')]")).click();
        Thread.sleep(5000);

    }
    @And("i click create new group button")
    public void i_click_create_new_group_button() {
        driver.findElement(By.xpath("//button[contains(.,'Create New Group')]")).click();

    }
    @And("i enter the group name (.*)$")
    public void i_enter_the_group_name(String groupName) {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(groupName);
    }
    @And("i enter the group description (.*)$")
    public void i_enter_the_group_description(String groupDescription) {
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(groupDescription);
    }

    @And("i enter the year (.*)$")
    public void i_enter_the_year(String year) {
        driver.findElement(By.name("year")).clear();
        driver.findElement(By.name("year")).sendKeys(year);
    }
    @And("i enter the max capacity (.*)$")
    public void i_enter_the_max_capacity(String maxCapacity) {
        driver.findElement(By.xpath("//input[@name='maxCapacity']")).sendKeys(maxCapacity);

    }
    @And("i enter the start date (.*)$")
    public void i_enter_the_start_date(String startDate) {
        String[] parts = startDate.split("/");

        driver.findElement(By.name("startDate")).click();

        driver.findElement(By.name("startDate"))
                .sendKeys(
                        parts[0],
                        Keys.ARROW_RIGHT,
                        parts[1],
                        Keys.ARROW_RIGHT,
                        parts[2]
                );
    }

    @And("i enter the end date (.*)$")
     public void i_enter_the_end_date(String endDate) {
        String[] parts = endDate.split("/");

        driver.findElement(By.name("endDate")).click();

        driver.findElement(By.name("endDate"))
                .sendKeys(
                        parts[0],
                        Keys.ARROW_RIGHT,
                        parts[1],
                        Keys.ARROW_RIGHT,
                        parts[2]
                );

    }
    @And("i click create button")
    public void i_click_create_button() {
        driver.findElement(By.xpath("//button[contains(.,'Create Group')]")).click();
    }
    @Then("the group should be created")
    public void the_group_should_be_created() {
        assert driver.findElement(By.xpath("//div[contains(text(),'Group created successfully!')]")).isDisplayed();
    }
}
