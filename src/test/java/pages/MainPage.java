package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.jq.Main;

public class MainPage extends PageObject {

    @FindBy(xpath = "//a[contains(.,'Home')]")
    WebElement homeBtn;

    @FindBy(xpath = "//a[contains(.,'Sign in')]")
    WebElement signInBtn;

    @FindBy(xpath = "//a[contains(.,'New Article')]")
    WebElement newArticleBtn;

    @FindBy(xpath = "//a[contains(.,'Global Feed')]")
    WebElement globalFeedBtn;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage goToHomePage() {
        homeBtn.click();
        return this;
    }

    public LoginPage goToLogin() {
        signInBtn.click();
        return new LoginPage(driver);
    }

    public NewArticlePage createNewArticle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'New Article')]")));

        newArticleBtn.click();
        return new NewArticlePage(driver);
    }

    public GlobalFeedPage goToGlobalFeed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Global Feed')]")));

        globalFeedBtn.click();
        return new GlobalFeedPage(driver);
    }

}
