package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.models.registration.request.RequestRegistration;
import site.nomoreparties.stellarburgers.pom.page.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static site.nomoreparties.stellarburgers.driver.WebDriverCreator.createWebDriver;
import static site.nomoreparties.stellarburgers.util.GeneratorUsersRegistration.fakeUserWith5Symbol;

public class RegistrationNegativeTest {
    private WebDriver driver;
    private RegistrationPage objRegistrationPage;
    private RequestRegistration requestRegistration;

    @Before
    public void setUp() {
        driver = createWebDriver();
        objRegistrationPage = new RegistrationPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        requestRegistration = fakeUserWith5Symbol();
    }
    @Test
    @DisplayName("Негативная проверка на минимальное кол-во символов(5)")
    public void registrationPassword5SymbolReturnLoginPage() {
        objRegistrationPage.getUrl();
        objRegistrationPage.sendKeysLogin(requestRegistration.getName());
        objRegistrationPage.sendKeysMail(requestRegistration.getEmail());
        objRegistrationPage.sendKeysPassword(requestRegistration.getPassword());
        objRegistrationPage.clickToButtonRegistration();

        Assert.assertEquals("Регистрация прошла успешно", "Некорректный пароль", objRegistrationPage.getTextError());
    }
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
