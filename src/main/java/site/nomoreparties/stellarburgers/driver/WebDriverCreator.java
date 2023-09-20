package site.nomoreparties.stellarburgers.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverCreator {
    //  Добавил такую конструкцию драйвера, но не так, как показывал наставник, я решил добавить в ресурсы вебдрайвер 114 версии для яндекс браузера.
    //  Всё работает и удобнее принимать код наверняка, что бы не устанавливать дополнительно ничего и не писать пути, не знаю можно ли так делать..
    // Для хрома не стал ничего добавлять, т.к. он автоматически сейчас подстраивается под установленный браузер, у меня все тесты проходили по 117-й версии.
    // Пытался ещё избавится от добавления пути до Яндекс браузера в системную переменную YANDEX_BROWSER_PATH, но так и не вышло, его всетаки пришлось добавлять.
    // Можно ли как то обойтись и без добавления пути до браузера? ну то есть передал весь проект и другой человек открыл и всё работает и ничего добавлять не нужно ?
    // Или это норм практика ? Заранее спасибо )

    public static WebDriver createWebDriver() {
        String browser = System.getenv("browser");
        if (browser == null) {
            return createChromeDriver();
        }
        switch (browser) {
            case "yandex":
                return createYandexDriver();
            case "chrome":
            default:
                return createChromeDriver();
        }
    }
    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }
    private static WebDriver createYandexDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(System.getenv("YANDEX_BROWSER_PATH"));
        return new ChromeDriver(options);
    }
}