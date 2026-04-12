package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static tests.testdata.TestData.*;

public class SmallRegistrationFormTest extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/text-box");

        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);

        $("#submit").click();

        $("#name").shouldHave(text(userName));
        $("#email").shouldHave(text(userEmail));
        $("#currentAddress.mb-1").shouldHave(text(currentAddress));
        $("#permanentAddress.mb-1").shouldHave(text(permanentAddress));

    }

    @Test
    void failedFillFormTest() {
        open("/text-box");

        $("#userName").setValue(userName);
        $("#userEmail").setValue(failedUserEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);

        $("#submit").click();

        $("#userEmail").shouldHave(cssClass(errorClass));

    }
}