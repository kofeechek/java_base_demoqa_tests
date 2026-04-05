package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SmallRegistrationFormTest extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/text-box");

        $("#userName").setValue("Pureshka s kotletkoy");
        $("#userEmail").setValue("pureshka@gmail.com");
        $("#currentAddress").setValue("Tarelka");
        $("#permanentAddress").setValue("Kastrulka");

        $("#submit").click();

        $("#name").shouldHave(text("Pureshka s kotletkoy"));
        $("#email").shouldHave(text("pureshka@gmail.com"));
        $("#currentAddress.mb-1").shouldHave(text("Tarelka"));
        $("#permanentAddress.mb-1").shouldHave(text("Kastrulka"));

    }

    @Test
    void failedFillFormTest() {
        open("/text-box");

        $("#userName").setValue("Pureshka s kotletkoy");
        $("#userEmail").setValue("pureshka");
        $("#currentAddress").setValue("Tarelka");
        $("#permanentAddress").setValue("Kastrulka");

        $("#submit").click();

        $("#userEmail").shouldHave(cssClass("field-error"));

    }
}