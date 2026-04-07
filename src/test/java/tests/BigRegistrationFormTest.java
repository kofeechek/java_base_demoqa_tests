package tests;

import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static tests.testdata.TestData.*;

public class BigRegistrationFormTest extends TestBase {

    @Test
    void successfulFillFormAllInputsTest () {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-1").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2000");
        $$(".react-datepicker__month").findBy(text("19")).click();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFile(new File("src/test/java/tests/resources/img/1.jpg"));
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click(ClickOptions.usingJavaScript());

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text(firstName + " " + lastName));
        $(".table").shouldHave(text(userEmail));
        $(".table").shouldHave(text("Male"));
        $(".table").shouldHave(text(userNumber));
        $(".table").shouldHave(text("19 January,2000"));
        $(".table").shouldHave(text("Sports"));
        $(".table").shouldHave(text("1.jpg"));
        $(".table").shouldHave(text(currentAddress));
        $(".table").shouldHave(text("NCR Delhi"));

    }

    @Test
    void successfulFillFormRequiredInputsTest () {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#gender-radio-1").click();
        $("#userNumber").setValue(userNumber);

        $("#submit").click(ClickOptions.usingJavaScript());

        $("#example-modal-sizes-title-lg").shouldHave(text(successMessage));
        $(".table").shouldHave(text(firstName + " " + lastName));
        $(".table").shouldHave(text("Male"));
        $(".table").shouldHave(text(userNumber));
    }

    @Test
    void failedFillFormFirstNameIsEmptyTest () {
        open("/automation-practice-form");

        $("#lastName").setValue(lastName);
        $("#gender-radio-1").click();
        $("#userNumber").setValue(userNumber);

        $("#submit").click(ClickOptions.usingJavaScript());

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }


    @Test
    void failedFillFormGenderIsEmptyTest () {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userNumber").setValue(userNumber);

        $("#submit").click(ClickOptions.usingJavaScript());

        $("#gender-radio-1").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void failedFillFormUserNumberFilledByLettersTest () {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#gender-radio-1").click();
        $("#userNumber").setValue(failedUserNumber);

        $("#submit").click(ClickOptions.usingJavaScript());

        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

}
