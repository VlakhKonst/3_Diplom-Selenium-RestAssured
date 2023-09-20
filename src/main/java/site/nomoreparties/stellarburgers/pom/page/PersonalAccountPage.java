package site.nomoreparties.stellarburgers.pom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {

    private WebDriver driver;

    private final By buttonExit = By.xpath(".//button[text()='Выход']");
    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickToButtonExit() {
        driver.findElement(buttonExit).click();
    }
}
