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

        $("#firstName").setValue("Tony");
        $("#lastName").setValue("Stark");
        $("#userEmail").setValue("tonystark@mail.ru");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2000");
        $$(".react-datepicker__month").findBy(text("19")).click();
        $("#subjectsInput").setValue("Subject");
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFile(new File("src/test/java/tests/resources/img/1.jpg"));
        $("#currentAddress").setValue("Avengers Tower");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click(ClickOptions.usingJavaScript());

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text("Tony Stark"));
        $(".table").shouldHave(text("tonystark@mail.ru"));
        $(".table").shouldHave(text("Male"));
        $(".table").shouldHave(text("0123456789"));
        $(".table").shouldHave(text("19 January,2000"));
        $(".table").shouldHave(text("Sports"));
        $(".table").shouldHave(text("1.jpg"));
        $(".table").shouldHave(text("Avengers Tower"));
        $(".table").shouldHave(text("NCR Delhi"));

    }

    @Test
    void successfulFillFormRequiredInputsTest () {
        open("/automation-practice-form");

        $("#firstName").setValue("Peter");
        $("#lastName").setValue("Parker");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("9876543210");

        $("#submit").click(ClickOptions.usingJavaScript());

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text("Peter Parker"));
        $(".table").shouldHave(text("Male"));
        $(".table").shouldHave(text("9876543210"));
    }

    @Test
    void failedFillFormFirstNameIsEmptyTest () {
        open("/automation-practice-form");

        $("#lastName").setValue("Parker");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("9876543210");

        $("#submit").click(ClickOptions.usingJavaScript());

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }


    @Test
    void failedFillFormGenderIsEmptyTest () {
        open("/automation-practice-form");

        $("#firstName").setValue("Peter");
        $("#lastName").setValue("Parker");
        $("#userNumber").setValue("9876543210");

        $("#submit").click(ClickOptions.usingJavaScript());

        $("#gender-radio-1").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void failedFillFormUserNumberFilledByLettersTest () {
        open("/automation-practice-form");

        $("#firstName").setValue("Peter");
        $("#lastName").setValue("Parker");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("abcdefghij");

        $("#submit").click(ClickOptions.usingJavaScript());

        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    private void selectFromDropdown(String s, String ncr) {
    }
}
