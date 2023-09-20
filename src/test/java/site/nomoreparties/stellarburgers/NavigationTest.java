package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.pom.page.LoginPage;
import site.nomoreparties.stellarburgers.pom.page.MainPage;
import site.nomoreparties.stellarburgers.pom.page.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static site.nomoreparties.stellarburgers.driver.WebDriverCreator.createWebDriver;

public class NavigationTest {
    private String expectResult = "Соберите бургер";
    private WebDriver driver;
    private LoginPage objLoginPage;
    private MainPage objMainPage;

    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        objLoginPage = new LoginPage(driver);
        objMainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Переход к разделу КОНСТРУКТОР")
    public void switchingToConstructorReturnMainPage () {
        objMainPage.getUrl();
        objMainPage.clickToPersonalAccount();
        objLoginPage.clickToConstructor();

        Assert.assertEquals(expectResult, objMainPage.getTextMainHeading());
    }
    @Test
    @DisplayName("Переход к ЛОГОТИП")
    public void switchingToLogoReturnMainPage () {
        objMainPage.getUrl();
        objMainPage.clickToPersonalAccount();
        objLoginPage.clickToMainLogo();

        Assert.assertEquals(expectResult, objMainPage.getTextMainHeading());
    }
    @Test
    @DisplayName("Переход к разделу НАЧИНКИ")
    public void switchingToLinkFillingsReturnFillings () {
        expectResult = "Начинки";
        objMainPage.getUrl();
        Assert.assertEquals(expectResult, objMainPage.clickToLink(3));
    }
    @Test
    @DisplayName("Переход к разделу СОУСЫ")
    public void switchingToLinkSaucesReturnSauces () {
        expectResult = "Соусы";
        objMainPage.getUrl();
        Assert.assertEquals(expectResult, objMainPage.clickToLink(2));
    }
    @Test
    @DisplayName("Переход к разделу БУЛКИ")
    public void switchingToLinkBunsReturnBuns () {
        expectResult = "Булки";
        objMainPage.getUrl();
        objMainPage.clickToLink(2);

        Assert.assertEquals(expectResult, objMainPage.clickToLink(1));
    }
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
