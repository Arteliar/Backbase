package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GlobalFeedPage extends MainPage{

    public GlobalFeedPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-article-preview")));
        PageFactory.initElements(driver, this);
    }

    public ArticlePage goToArticle(String title) {
        driver.findElement(By.xpath("//h1[contains(.,'" + title + "')]")).click();
        return new ArticlePage(driver);
    }

    public boolean checkIfExist(String title) {
        try {
            driver.findElement(By.xpath("//h1[contains(.,'" + title + "')]"));
        }
        catch(Exception e) {
            return false;
        }

        return true;
    }

}
