package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ArticlePage extends MainPage{

    @FindBy(xpath = "//h1")
    WebElement articleTitle;

    @FindBy(xpath = "//p")
    WebElement articleBody;

    @FindBy(xpath = "//a[contains(.,'Edit Article')]")
    WebElement editBtn;

    @FindBy(xpath = "//button[contains(.,'Delete Article')]")
    WebElement deleteBtn;

    public ArticlePage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='article-page']//div[@class='article-meta']")));

        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return articleTitle.getText();
    }

    public String getBody() {
        return articleBody.getText();
    }

    public NewArticlePage editArticle() {
        editBtn.click();

        return new NewArticlePage(driver);
    }

    public MainPage deleteArticle() {
        deleteBtn.click();

        return new MainPage(driver);
    }
}
