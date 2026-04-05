package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BigRegistrationFormTest extends TestBase {

    @Test
    void successfulFillFormTest () {
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
        $("[id=state]").click();
        selectFromDropdown("[id=state]", "NCR");
        selectFromDropdown("[id=city]", "Delhi");
        $("[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));

    }

    private void selectFromDropdown(String s, String ncr) {
    }
}
