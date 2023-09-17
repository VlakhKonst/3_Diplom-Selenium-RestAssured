package site.nomoreparties.stellarburgers.pom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {

    private final WebDriver driver;
    private final By pathToLinkPasswordRecovery = By.xpath(".//a[text()='Восстановить пароль']");
    private final By pathToLinkLogin = By.xpath(".//a[@href='/login']");

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickToLinkPasswordRecovery() {
        driver.findElement(pathToLinkPasswordRecovery).click();
    }
    public void clickPathToLinkLogin() {
        driver.findElement(pathToLinkLogin).click();
    }

}
