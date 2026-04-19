package tests;

import org.junit.jupiter.api.Test;
import static tests.testdata.TestData.*;

public class RegistrationTests extends TestBase {


    @Test
    void successfulFillFormAllInputsTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .setGender(userGender)
                .typeUserNumber(userNumber)
                .setDateOfBirth(calendarDay, calendarMonth, calendarYear)
                .setHobby(userHobby)
                .uploadImage(userImage)
                .typeUserCurrentAddress(currentAddress)
                .setStateAndCity(userState, userCity)

                .submitRegistrationForm()

                .successMessageCheck(successMessage)
                .checkResult(firstName + " " + lastName)
                .checkResult(userEmail)
                .checkResult(userGender)
                .checkResult(userNumber)
                .checkResult(calendarDay + " " + calendarMonth + "," + calendarYear)
                .checkResult(userHobby)
                .checkResult(userImage)
                .checkResult(currentAddress)
                .checkResult(userState + " " + userCity);

    }

    @Test
    void successfulFillFormRequiredInputsTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(userGender)
                .typeUserNumber(userNumber)

                .submitRegistrationForm()

                .successMessageCheck(successMessage)
                .checkResult(firstName)
                .checkResult(lastName)
                .checkResult(userGender)
                .checkResult(userNumber);

    }

    @Test
    void failedFillFormFirstNameIsEmptyTest() {
        registrationPage.openPage()
                .typeLastName(lastName)
                .setGender(userGender)
                .typeUserNumber(userNumber)

                .submitRegistrationForm()

                .emptyFirstNameCheck(errorCssKey, errorCssValue);
    }


    @Test
    void failedFillFormGenderIsEmptyTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserNumber(userNumber)

                .submitRegistrationForm()

                .emptyUserGenderCheck(errorCssKey, errorCssValue);

    }

    @Test
    void failedFillFormUserNumberFilledByLettersTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(userGender)
                .typeUserNumber(failedUserNumber)

                .submitRegistrationForm()

                .failedUserNumberCheck(errorCssKey, errorCssValue);
    }

}
