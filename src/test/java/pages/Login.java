package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class Login {



    public Login(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement emailInput;

    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-login btn-block']")
    public WebElement loginBtn;

    @FindBy(xpath = "//a[@class=\"active\"]/span")
    public WebElement Anasayfa;

    @FindBy(xpath = "//div[@class=\"alert alert-warning fade in\"]/p")
    public WebElement Alert;
}
