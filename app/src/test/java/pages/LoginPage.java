package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://dev-alazharpontianak.pintro.id/login");
    }

    public void login(String username, String password) {
        driver.findElement(By.cssSelector(".required[name='username']")).sendKeys(username);
        driver.findElement(By.id("user-password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='login']")).click();
    }
}
