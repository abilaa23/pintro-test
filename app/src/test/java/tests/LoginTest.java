package tests;

import org.junit.jupiter.api.Test;
import pages.*;
import utils.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginAndPaymentFlow() {
        // Membuka halaman login
        LoginPage login = new LoginPage(driver);
        login.open();

        // Melakukan login
        login.login("2502015", "280425");

        // Menunggu halaman Home ter-load setelah login
        HomePage home = new HomePage(driver);
        wait.until(driver -> home.isLoaded());

        // Mengakses halaman student dan melakukan pembayaran
        StudentPage student = new StudentPage(driver);
        student.openStudentPage();
        student.verifyDataOnStudentPage();
        student.processPaymentPage();
        student.openStudentPage();


        // Logout setelah transaksi
        home.logout();
        wait.until(ExpectedConditions.urlContains("/login"));
    }
}
