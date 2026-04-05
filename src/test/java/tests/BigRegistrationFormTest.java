package tests;

import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BigRegistrationFormTest extends TestBase {

    @Test
    void successfulFillFormAllInputsTest () {
        open("/automation-practice-form");

        $("[id=firstName]").setValue("Tony");
        $("[id=lastName]").setValue("Stark");
        $("[id=userEmail]").setValue("tonystark@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("0123456789");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2000");
        $$(".react-datepicker__month").findBy(text("6")).click();
        $("[id=subjectsInput]").setValue("Subject");
        $("[id=hobbies-checkbox-1]").click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/java/tests/resources/img/1.jpg"));
        $("[id=currentAddress]").setValue("Avengers Tower");
        selectFromDropdown("[id=state]", "NCR");
        selectFromDropdown("[id=city]", "Delhi");

        $("[id=submit]").click(ClickOptions.usingJavaScript());

        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));

    }

    @Test
    void successfulFillFormRequiredInputsTest () {
        open("/automation-practice-form");

        $("[id=firstName]").setValue("Peter");
        $("[id=lastName]").setValue("Parker");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("9876543210");

        $("[id=submit]").click(ClickOptions.usingJavaScript());

        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));

    }

    @Test
    void failedFillFormFirstNameIsEmptyTest () {
        open("/automation-practice-form");

        $("[id=lastName]").setValue("Parker");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("9876543210");

        $("[id=submit]").click(ClickOptions.usingJavaScript());

        $("[id=firstName]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }


    @Test
    void failedFillFormGenderIsEmptyTest () {
        open("/automation-practice-form");

        $("[id=firstName]").setValue("Peter");
        $("[id=lastName]").setValue("Parker");
        $("[id=userNumber]").setValue("9876543210");

        $("[id=submit]").click(ClickOptions.usingJavaScript());

        $("[id=gender-radio-1]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void failedFillFormUserNumberFilledByLettersTest () {
        open("/automation-practice-form");

        $("[id=firstName]").setValue("Peter");
        $("[id=lastName]").setValue("Parker");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("abcdefghij");

        $("[id=submit]").click(ClickOptions.usingJavaScript());

        $("[id=userNumber]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    private void selectFromDropdown(String s, String ncr) {
    }
}
