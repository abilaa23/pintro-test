package tests;

import org.junit.jupiter.api.Test;
import pages.*;
import utils.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterTest extends BaseTest {

    @Test
    public void testRegisterProcess() {
        // Membuka halaman register
        RegisterPage register = new RegisterPage(driver);
        register.open();

        // Mengisi form pendaftaran (step 1)
         String name = "Tester Auto";
         String pob = "Pontianak";
         String dobDay = "12";
         String dobMonth = "Mei";
         String dobYear = "2005";
         String level = "SMA";

         register.register1(name, pob, dobDay, dobMonth, dobYear, level);
    }
}
