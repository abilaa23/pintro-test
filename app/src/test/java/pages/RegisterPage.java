package pages;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private void ensureWindowIsOpen() {
        if (driver.getWindowHandles().isEmpty()) {
            throw new IllegalStateException("Browser window is not available.");
        }
    }

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://pmb-dev-alazharpontianak.pintro.id/enroll-new");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
    }

    public void register1(String name, String pob, String dob_day, String dob_month, String dob_year, String level) {
        
        ensureWindowIsOpen();

        System.out.println("Waiting for the modal to become visible...");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content")));

        System.out.println("Waiting for the 'Baik, Saya mengerti' button to be clickable...");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Baik, Saya mengerti']"))).click();

        System.out.println("Waiting for the input field to be clickable...");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='name']"))).sendKeys(name);

        driver.findElement(By.name("pob")).sendKeys(pob);
        driver.findElement(By.name("dob_day")).sendKeys(dob_day);

        new Select(driver.findElement(By.name("dob_month"))).selectByVisibleText(dob_month);
        driver.findElement(By.name("dob_year")).sendKeys(dob_year);

        driver.findElement(By.id("perem")).click();

        new Select(driver.findElement(By.id("level"))).selectByVisibleText(level);
        new Select(driver.findElement(By.id("ng_department_id"))).selectByIndex(1);
        new Select(driver.findElement(By.id("ng_applicant_type_id"))).selectByIndex(1);
        new Select(driver.findElement(By.id("ng_class_level_id"))).selectByIndex(1);
        new Select(driver.findElement(By.id("ng_class_type_id"))).selectByIndex(1);
        new Select(driver.findElement(By.id("test_type"))).selectByIndex(1);

        driver.findElement(By.name("school_of_origin")).sendKeys("SMA Contoh");

    // Untuk tombol "Pilih Sumber" dan "Pilih Alasan Anda Mendaftar"
        driver.findElement(By.xpath("//button[contains(text(),'Pilih Sumber')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Teman')]")).click(); // misalnya pilih opsi

        driver.findElement(By.xpath("//button[contains(text(),'Pilih Alasan Anda Mendaftar')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Kualitas Pendidikan')]")).click(); // misalnya pilih opsi

        driver.findElement(By.id("next")).click();
    }


    // public void register2(String enquirer, String status, String job_type, String address, String cellphone, String email) {
    //     driver.findElement(By.cssSelector("[name='enquirer']")).sendKeys(enquirer);
    //     driver.findElement(By.cssSelector("[aria-owns='bs-select-8'] .filter-option-inner-inner")).sendKeys(status);
    //     driver.findElement(By.xpath("//select[@name='ng_job_type_id']")).sendKeys(job_type);
    //     driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(address);
    //     driver.findElement(By.cssSelector("[name='cellphone']")).sendKeys(cellphone);
    //     driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
    //     driver.findElement(By.cssSelector("[aria-owns='bs-select-9'] .filter-option-inner-inner")).sendKeys(email);
    //     driver.findElement(By.cssSelector("[aria-owns='bs-select-10'] .filter-option-inner-inner")).sendKeys(email);
    //     driver.findElement(By.cssSelector("[aria-owns='bs-select-11'] .filter-option-inner-inner")).sendKeys(email);
    //     driver.findElement(By.cssSelector("[name='postcode']")).sendKeys(email);
    //     driver.findElement(By.cssSelector("#terms")).click();
    //     driver.findElement(By.id("next")).click();
    // }
}
