package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.models.delete.Delete;
import site.nomoreparties.stellarburgers.models.registration.request.RequestRegistration;
import site.nomoreparties.stellarburgers.models.registration.response.ResponseRegistration;
import site.nomoreparties.stellarburgers.pom.page.LoginPage;
import site.nomoreparties.stellarburgers.pom.page.MainPage;
import site.nomoreparties.stellarburgers.pom.page.PasswordRecoveryPage;
import site.nomoreparties.stellarburgers.pom.page.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
import static site.nomoreparties.stellarburgers.Environment.BASE_URL;
import static site.nomoreparties.stellarburgers.driver.WebDriverCreator.createWebDriver;
import static site.nomoreparties.stellarburgers.util.GeneratorUsersDelete.userDelete;
import static site.nomoreparties.stellarburgers.util.GeneratorUsersRegistration.fakeUser;

public class LogInToSystemTest {
    private final String expectResult = "Соберите бургер";
    Method method = new Method();
    private WebDriver driver;
    private RegistrationPage objRegistrationPage;
    private LoginPage objLoginPage;
    private MainPage objMainPage;
    private RequestRegistration requestRegistration;
    private Delete delete;
    private PasswordRecoveryPage objPasswordRecoveryPage;
    Response response;

    @Before
    public void SetUp() {
        driver = createWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        objRegistrationPage = new RegistrationPage(driver);
        objLoginPage = new LoginPage(driver);
        objMainPage = new MainPage(driver);
        objPasswordRecoveryPage = new PasswordRecoveryPage(driver);

        baseURI = BASE_URL;
        requestRegistration = fakeUser();
        response = method.registrationUser(requestRegistration);
    }
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void loginMainPageThroughButtonReturnSuccessfulAuth() {
        objMainPage.getUrl();
        objMainPage.clickButtonLogInToYourAccount();
        objLoginPage.sendKeysMail(requestRegistration.getEmail());
        objLoginPage.sendKeysPassword(requestRegistration.getPassword());
        objLoginPage.clickToButtonEnter();

        Assert.assertEquals(expectResult, objMainPage.getTextMainHeading());
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void loginMainPageThroughPersonalAccountReturnSuccessfulAuth() {
        objMainPage.getUrl();
        objMainPage.clickToPersonalAccount();
        objLoginPage.sendKeysMail(requestRegistration.getEmail());
        objLoginPage.sendKeysPassword(requestRegistration.getPassword());
        objLoginPage.clickToButtonEnter();

        Assert.assertEquals(expectResult, objMainPage.getTextMainHeading());
    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFormRegistrationPageReturnSuccessfulAuth() {

        objRegistrationPage.getUrl();
        objRegistrationPage.clickToButtonEnter();
        objLoginPage.sendKeysMail(requestRegistration.getEmail());
        objLoginPage.sendKeysPassword(requestRegistration.getPassword());
        objLoginPage.clickToButtonEnter();

        Assert.assertEquals(expectResult, objMainPage.getTextMainHeading());
    }
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Test
    public void loginPasswordRecoveryPageReturnSuccessfulAuth() {

        objMainPage.getUrl();
        objMainPage.clickToPersonalAccount();
        objPasswordRecoveryPage.clickToLinkPasswordRecovery();
        objPasswordRecoveryPage.clickPathToLinkLogin();
        objLoginPage.sendKeysMail(requestRegistration.getEmail());
        objLoginPage.sendKeysPassword(requestRegistration.getPassword());
        objLoginPage.clickToButtonEnter();

        Assert.assertEquals(expectResult, objMainPage.getTextMainHeading());
    }
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
        delete = userDelete(requestRegistration);
        method.deleteUser(delete, ResponseRegistration.gettingResponse(response));
    }

}
