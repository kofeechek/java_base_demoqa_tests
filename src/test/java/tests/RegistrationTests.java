package tests;

import org.junit.jupiter.api.Test;
import tests.testdata.TestData;

public class RegistrationTests extends TestBase {

    TestData testData = new TestData();

    @Test
    void successfulFillFormAllInputsTest() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeUserEmail(testData.userEmail)
                .setGender(testData.userGender)
                .typeUserNumber(testData.userNumber)
                .setDateOfBirth(testData.calendarDay, testData.calendarMonth, testData.calendarYear)
                .setHobby(testData.userHobby)
                .uploadImage(testData.userImage)
                .typeUserCurrentAddress(testData.currentAddress)
                .setStateAndCity(testData.userState, testData.userCity)

                .submitRegistrationForm()

                .successMessageCheck(testData.successMessage)
                .checkResult(testData.firstName + " " + testData.lastName)
                .checkResult(testData.userEmail)
                .checkResult(testData.userGender)
                .checkResult(testData.userNumber)
                .checkResult(testData.calendarDay + " " + testData.calendarMonth + "," + testData.calendarYear)
                .checkResult(testData.userHobby)
                .checkResult(testData.userImage)
                .checkResult(testData.currentAddress)
                .checkResult(testData.userState + " " + testData.userCity);

    }

    @Test
    void successfulFillFormRequiredInputsTest() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .setGender(testData.userGender)
                .typeUserNumber(testData.userNumber)

                .submitRegistrationForm()

                .successMessageCheck(testData.successMessage)
                .checkResult(testData.firstName)
                .checkResult(testData.lastName)
                .checkResult(testData.userGender)
                .checkResult(testData.userNumber);

    }

    @Test
    void failedFillFormFirstNameIsEmptyTest() {
        registrationPage.openPage()
                .typeLastName(testData.lastName)
                .setGender(testData.userGender)
                .typeUserNumber(testData.userNumber)

                .submitRegistrationForm()

                .emptyFirstNameCheck(testData.errorCssKey, testData.errorCssValue);
    }


    @Test
    void failedFillFormGenderIsEmptyTest() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeUserNumber(testData.userNumber)

                .submitRegistrationForm()

                .emptyUserGenderCheck(testData.errorCssKey, testData.errorCssValue);

    }

    @Test
    void failedFillFormUserNumberFilledByLettersTest() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .setGender(testData.userGender)
                .typeUserNumber(testData.failedUserNumber)

                .submitRegistrationForm()

                .failedUserNumberCheck(testData.errorCssKey, testData.errorCssValue);
    }

}

