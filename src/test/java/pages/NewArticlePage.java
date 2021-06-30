package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewArticlePage extends MainPage {

    @FindBy(xpath = "//fieldset/fieldset[1]/input")
    WebElement titleField;

    @FindBy(xpath = "//fieldset/fieldset[2]/input")
    WebElement summaryField;

    @FindBy(xpath = "//fieldset/fieldset[3]/textarea")
    WebElement bodyField;

    @FindBy(xpath = "//fieldset/fieldset[4]/input")
    WebElement tagsField;

    @FindBy(xpath = "//button[contains(.,'Publish Article')]")
    WebElement publishBtn;

    public NewArticlePage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Publish Article')]")));

        PageFactory.initElements(driver, this);
    }

    public ArticlePage publishNewArticle(String title, String summary, String body, String tags) {
        titleField.sendKeys(title);
        summaryField.sendKeys(summary);
        bodyField.sendKeys(body);
        tagsField.sendKeys(tags);
        publishBtn.click();

        return new ArticlePage(driver);
    }

    public ArticlePage editArticle(String body) {
        bodyField.clear();
        bodyField.sendKeys(body);
        publishBtn.click();

        return new ArticlePage(driver);
    }
}
