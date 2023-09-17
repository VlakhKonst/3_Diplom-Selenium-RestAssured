package site.nomoreparties.stellarburgers.pom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/";
    private final By mainHeading = By.xpath(".//h1");
    private final By pathToPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By pathButtonLogInToYourAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void getUrl() {
        driver.get(url);
    }
    public String getTextMainHeading() {
        return driver.findElement(mainHeading).getText();
    }
    public void clickToPersonalAccount() {
        driver.findElement(pathToPersonalAccount).click();
    }
    public void clickButtonLogInToYourAccount() {
        driver.findElement(pathButtonLogInToYourAccount).click();
    }
    public String clickToLink(int num) {
        driver.findElement(By.xpath(String.format("//div[@style]//div[%s]", num))).click();
        return driver.findElement(By.xpath((".//div[contains(@class, 'current')]"))).getText();
    }
}
