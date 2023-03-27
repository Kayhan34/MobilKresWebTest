package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Login;
import utility.ConfigurationReader;
import utility.Driver;

public class LoginTest {

    Login login = new Login();

    @Given("user go to the login page")
    public void user_go_to_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("login_url"));
    }
    @When("user enters correct credentials")
    public void user_enters_correct_credentials() {
        String email = ConfigurationReader.getProperty("email");
        String password = ConfigurationReader.getProperty("password");

        login.emailInput.sendKeys(email);
        login.passwordInput.sendKeys(password);
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),3);
        login.loginBtn.click();

    }
    @Then("user should be in {string}")
    public void user_should_be_in(String string) {
        String actualTitle = login.Anasayfa.getText();
        Assert.assertEquals(string,actualTitle);
    }

    @When("user enters wrong credentials")
    public void user_enters_wrong_credentials() {
        String wrong_mail = ConfigurationReader.getProperty("wrong_mail");
        String password = ConfigurationReader.getProperty("password");

        login.emailInput.sendKeys(wrong_mail);
        login.passwordInput.sendKeys(password);
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),3);
        login.loginBtn.click();
    }
    @Then("user should see {string}")
    public void user_should_see (String string) {
        Driver.getDriver().findElement(By.xpath("//div[@class=\"alert alert-warning fade in\"]/p")).isDisplayed();
    }
}
