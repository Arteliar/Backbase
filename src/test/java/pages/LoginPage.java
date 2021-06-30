package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObject{

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signInBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInBtn.click();

        return new MainPage(driver);
    }
}
