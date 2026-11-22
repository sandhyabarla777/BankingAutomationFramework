package com.banking.tests;




import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.base.BaseTest;
import com.banking.pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test
    public void verifyRegistration() {

        RegistrationPage registration =
                new RegistrationPage(getDriver());

        registration.clickRegister();

        registration.registrationForm(
                "Sandhya",
                "Testing",
                "Hyderabad",
                "Hyderabad",
                "Telangana",
                "500001",
                "9876543212",
                "12345678",
                "sandhya_test_2029",
                "Test@123"
                
        );
        String actualMessage = registration.getWelcomeMessage();

        Assert.assertTrue(
            actualMessage.startsWith("Welcome"),
            "Welcome message is not displayed/Registration failed.."
        );

        /*Assert.assertTrue(
               getDriver().getPageSource().contains("Your account was created successfully"),
                "Registration was not successful"
        );*/
       
    }
}
 
