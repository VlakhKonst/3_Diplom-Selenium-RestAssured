package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.models.delete.Delete;
import site.nomoreparties.stellarburgers.models.login.request.RequestLogin;
import site.nomoreparties.stellarburgers.models.registration.request.RequestRegistration;
import site.nomoreparties.stellarburgers.pom.page.LoginPage;
import site.nomoreparties.stellarburgers.pom.page.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
import static site.nomoreparties.stellarburgers.Environment.BASE_URL;
import static site.nomoreparties.stellarburgers.driver.WebDriverCreator.createWebDriver;
import static site.nomoreparties.stellarburgers.util.GeneratorUserLogin.userLogin;
import static site.nomoreparties.stellarburgers.util.GeneratorUsersDelete.userDelete;
import static site.nomoreparties.stellarburgers.util.GeneratorUsersRegistration.fakeUserWith6Symbol;
import static site.nomoreparties.stellarburgers.util.GeneratorUsersRegistration.fakeUserWith7Symbol;

public class RegistrationPositiveTest {
    Method method = new Method();
    private WebDriver driver;
    private RegistrationPage objRegistrationPage;
    private RequestRegistration requestRegistration;
    private RequestLogin requestLogin;
    private Delete delete;
    private LoginPage loginPage;
    @Before
    public void setUp() {
        driver = createWebDriver();
        objRegistrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        baseURI = BASE_URL;
    }
    @Test
    @DisplayName("Успешная регистрация + проверка на кол-во символов(6)")
    public void registrationPassword6SymbolReturnLoginPage() {
        requestRegistration = fakeUserWith6Symbol();
        objRegistrationPage.getUrl();
        objRegistrationPage.sendKeysLogin(requestRegistration.getName());
        objRegistrationPage.sendKeysMail(requestRegistration.getEmail());
        objRegistrationPage.sendKeysPassword(requestRegistration.getPassword());
        objRegistrationPage.clickToButtonRegistration();

        Assert.assertEquals("Регистрация прошла не успешно", "Вход", loginPage.getTitle());
    }
    @Test
    @DisplayName("Успешная регистрация + проверка на кол-во символов(7)")
    public void registrationPassword7SymbolReturnLoginPage() {
        requestRegistration = fakeUserWith7Symbol();
        objRegistrationPage.getUrl();
        objRegistrationPage.sendKeysLogin(requestRegistration.getName());
        objRegistrationPage.sendKeysMail(requestRegistration.getEmail());
        objRegistrationPage.sendKeysPassword(requestRegistration.getPassword());
        objRegistrationPage.clickToButtonRegistration();

        Assert.assertEquals("Регистрация прошла не успешно", "Вход", loginPage.getTitle());
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();

        delete = userDelete(requestRegistration);
        requestLogin = userLogin(requestRegistration);
        method.deleteUserAfterLogin(delete, method.loginUser(requestLogin));
    }
}
