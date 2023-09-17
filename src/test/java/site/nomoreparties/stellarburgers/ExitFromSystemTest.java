package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.models.delete.Delete;
import site.nomoreparties.stellarburgers.models.registration.request.RequestRegistration;
import site.nomoreparties.stellarburgers.models.registration.response.ResponseRegistration;
import site.nomoreparties.stellarburgers.pom.page.*;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
import static org.junit.Assert.assertEquals;
import static site.nomoreparties.stellarburgers.Environment.BASE_URL;
import static site.nomoreparties.stellarburgers.driver.WebDriverCreator.createWebDriver;
import static site.nomoreparties.stellarburgers.util.GeneratorUsersDelete.userDelete;
import static site.nomoreparties.stellarburgers.util.GeneratorUsersRegistration.fakeUser;

public class ExitFromSystemTest {
    private final String expectResult = "Соберите бургер";
    Method method = new Method();
    private WebDriver driver;
    private PersonalAccountPage objPersonalAccountPage;
    private LoginPage objLoginPage;
    private MainPage objMainPage;
    private RequestRegistration requestRegistration;
    private Delete delete;
    private PasswordRecoveryPage objPasswordRecoveryPage;
    Response response;
    @Before
    public void setUp() {
        driver = createWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        objLoginPage = new LoginPage(driver);
        objMainPage = new MainPage(driver);
        objPersonalAccountPage = new PersonalAccountPage(driver);
        objPasswordRecoveryPage = new PasswordRecoveryPage(driver);

        baseURI = BASE_URL;
        requestRegistration = fakeUser();
        response = method.registrationUser(requestRegistration);

        objMainPage.getUrl();
        objMainPage.clickToPersonalAccount();
        objLoginPage.sendKeysMail(requestRegistration.getEmail());
        objLoginPage.sendKeysPassword(requestRegistration.getPassword());
    }
    @DisplayName("Выход из Личного Кабинета")
    @Test
    public void exitFromThePersonalAccountReturnLoginPage() {
        objLoginPage.clickToButtonEnter();
        objMainPage.clickToPersonalAccount();
        objPersonalAccountPage.clickToButtonExit();

        assertEquals("Вход", objLoginPage.getTitle());
    }
    @After
    public void tearDown(){
        driver.close();
        driver.quit();
        delete = userDelete(requestRegistration);
        method.deleteUser(delete, ResponseRegistration.gettingResponse(response));
    }
}
