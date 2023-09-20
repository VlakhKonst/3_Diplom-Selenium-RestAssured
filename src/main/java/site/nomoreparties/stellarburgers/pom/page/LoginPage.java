package site.nomoreparties.stellarburgers.pom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private String url = "https://stellarburgers.nomoreparties.site/login";
    private final By pathToMainTitle = By.xpath(".//h2[text()='Вход']");
    private final By pathToMail = By.xpath(".//form/fieldset[1]//input");
    private final By pathToPassword = By.xpath(".//form/fieldset[2]//input");
    private final By pathToButtonEnter = By.xpath(".//button[text()='Войти']");
    private final By pathToLinkConstructor = By.xpath(".//p[text()='Конструктор']");
    private final By pathToMainLogo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void getUrl() {
        driver.get(url);
    }
    public String getTitle() {
        return driver.findElement(pathToMainTitle).getText();
    }
    public void sendKeysMail(String mail) {
        driver.findElement(pathToMail).click();
        driver.findElement(pathToMail).sendKeys(mail);
    }
    public void sendKeysPassword(String password) {
        driver.findElement(pathToPassword).click();
        driver.findElement(pathToPassword).sendKeys(password);
    }
    public void clickToButtonEnter() {
        driver.findElement(pathToButtonEnter).click();
    }
    public void clickToConstructor(){
        driver.findElement(pathToLinkConstructor).click();
    }
    public void clickToMainLogo() {
        driver.findElement(pathToMainLogo).click();
    }
}
