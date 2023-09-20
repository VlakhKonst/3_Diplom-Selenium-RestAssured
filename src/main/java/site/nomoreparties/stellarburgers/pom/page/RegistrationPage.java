package site.nomoreparties.stellarburgers.pom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private final WebDriver driver;
    private String url = "https://stellarburgers.nomoreparties.site/register";
    private final By pathToLogin = By.xpath(".//form/fieldset[1]//input[@type='text']");
    private final By pathToMail = By.xpath(".//form/fieldset[2]//input[@type='text']");
    private final By pathToPassword = By.xpath(".//input[@type='password']");
    private final By pathToButtonRegistration = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By pathToTextError = By.xpath(".//p[@class='input__error text_type_main-default']");
    private final By pathToButtonEnter = By.xpath(".//a[@href='/login']");
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void getUrl() {
        driver.get(url);
    }
    public void sendKeysLogin(String login) {
        driver.findElement(pathToLogin).click();
        driver.findElement(pathToLogin).sendKeys(login);
    }
    public void sendKeysMail(String mail) {
        driver.findElement(pathToMail).click();
        driver.findElement(pathToMail).sendKeys(mail);
    }
    public void sendKeysPassword(String password) {
        driver.findElement(pathToPassword).click();
        driver.findElement(pathToPassword).sendKeys(password);
    }
    public String getTextError() {
        return driver.findElement(pathToTextError).getText();
    }
    public void clickToButtonRegistration() {
        driver.findElement(pathToButtonRegistration).click();
    }
    public void clickToButtonEnter() {
        driver.findElement(pathToButtonEnter).click();
    }
}
