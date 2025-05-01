package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class StudentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public StudentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openStudentPage() {
        driver.findElement(By.xpath("//span[.='Biodata Siswa']")).click();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("/ng_stu_biodata_new"));
    }

    public void verifyDataOnStudentPage() {

        String actualStudentName = driver.findElement(By.cssSelector(".text-md-start .font-size-24")).getText();
        String expectedStudentName = "Ariqah Nisrin N";

        String actualNomorInduk = driver.findElement(By.cssSelector("#identitas .py-3 > .row .text-p-teal")).getText();
        String expectedNomorInduk = "2502015";
    }

    public void processPaymentPage() {

        driver.findElement(By.xpath("//a[contains(.,'Pembayaran Online')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Pembayaran Aktif']"))).click();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("/ng_stu_unpaid_new"));


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name='select_row[]']")));
        driver.findElement(By.cssSelector("[name='select_row[]']")).click();
        String actualNomorInduk = driver.findElement(By.cssSelector("[for='checkbox_2']")).getText();
        String expectedNomorInduk = "Rp. 250,000";
        driver.findElement(By.xpath("//button[@id='process']")).click();
        wait.until(ExpectedConditions.urlContains("/ng_stu_unpaid_new/getDetailTransaction"));
        String currentUrlDetail = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrlDetail.contains("/ng_stu_unpaid_new/getDetailTransaction"));

        String actualTitleDetail = driver.findElement(By.cssSelector("#content > .row .font-size-24")).getText();
        String expectedTitleDetail = "Detail";
        driver.findElement(By.cssSelector(".channel-block")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-bs-target='#how_to_6683']"))).click();
        driver.findElement(By.cssSelector("#changeChannel")).click();
        String actualTagihan = driver.findElement(By.cssSelector(".col-xl-4 div:nth-of-type(2) > .text-nowrap")).getText();
        String expectedTagihan = "Rp. 250,000";
        String actualAdminFee = driver.findElement(By.cssSelector("#admin_fee")).getText();
        String expectedAdminFee = "Rp. 5,000";
        String actualTotal = driver.findElement(By.cssSelector(".text-nowrap.font-size-18")).getText();
        String expectedTotal = "Rp. 255,000";
    }
}
