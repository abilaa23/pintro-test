package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isLoaded() {
        return driver.getCurrentUrl().contains("/home");
    }

    public void logout() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".name")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".name"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='text-center logout']/div[contains(.,'Keluar')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='text-center logout']/div[contains(.,'Keluar')]"))).click();
    }
    
}
