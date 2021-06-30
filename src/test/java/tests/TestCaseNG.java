package tests;

import config.ChromeSetup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ArticlePage;
import pages.LoginPage;
import pages.MainPage;

public class TestCaseNG {
    WebDriver driver;

    @Parameters({"username", "password", "email", "emailPassword"})
    @BeforeTest
    public void setupBrowser(String username, String password, String email, String emailPassword) {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(new ChromeSetup().setup());
        driver.get("https://" + username + ":" + password + "@qa-task.backbasecloud.com/");

        LoginPage loginPage = new MainPage(driver).goToLogin();
        loginPage.login(email, emailPassword);
    }

    @BeforeMethod
    public void setupMainPage() {
        new MainPage(driver).goToHomePage();
    }

    @Parameters({"title", "summary", "body", "tags"})
    @Test
    public void createNewArticle(String title, String summary, String body, String tags) {
        ArticlePage articlePage = new MainPage(driver).createNewArticle().publishNewArticle(title, summary, body, tags);

        Assert.assertEquals(articlePage.getTitle(), title);
    }

    @Parameters({"title", "body"})
    @Test
    public void readExistingArticle(String title, String body) {
        ArticlePage articlePage = new MainPage(driver).goToGlobalFeed().goToArticle(title);

        Assert.assertEquals(articlePage.getBody(), body);
    }

    @Parameters({"title", "bodyEdit"})
    @Test
    public void updateExistingArticle(String title, String body) {
        new MainPage(driver).goToGlobalFeed().goToArticle(title).editArticle().editArticle(body).goToHomePage();
        ArticlePage articlePage = new MainPage(driver).goToGlobalFeed().goToArticle(title);

        Assert.assertEquals(articlePage.getBody(), body);
    }

    @Parameters({"title"})
    @Test
    public void deleteExistingArticle(String title) {
        new MainPage(driver).goToGlobalFeed().goToArticle(title).deleteArticle();

        Assert.assertFalse(new MainPage(driver).goToGlobalFeed().checkIfExist(title));
    }

    @AfterTest
    public void exit() {
        driver.close();
    }

}
