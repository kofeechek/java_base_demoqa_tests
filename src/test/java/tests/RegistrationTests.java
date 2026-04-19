package tests;

import org.junit.jupiter.api.Test;
import pages.components.ResultFormComponent;
import tests.testdata.TestData;

public class RegistrationTests extends TestBase {

    TestData testData = new TestData();
    ResultFormComponent resultFormComponent = new ResultFormComponent();

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

                .successMessageCheck(testData.successMessage);

        resultFormComponent.checkFormResults("Student Name", testData.firstName + " " + testData.lastName)
                .checkFormResults("Student Email", testData.userEmail)
                .checkFormResults("Gender", testData.userGender)
                .checkFormResults("Mobile", testData.userNumber)
                .checkFormResults("Date of Birth", testData.calendarDay + " " + testData.calendarMonth + "," + testData.calendarYear)
                .checkFormResults("Hobbies", testData.userHobby)
                .checkFormResults("Picture", testData.userImage)
                .checkFormResults("Address", testData.currentAddress)
                .checkFormResults("State and City", testData.userState + " " + testData.userCity);

    }

    @Test
    void successfulFillFormRequiredInputsTest() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .setGender(testData.userGender)
                .typeUserNumber(testData.userNumber)

                .submitRegistrationForm()

                .successMessageCheck(testData.successMessage);

        resultFormComponent.checkFormResults("Student Name", testData.firstName + " " + testData.lastName)
                .checkFormResults("Gender", testData.userGender)
                .checkFormResults("Mobile", testData.userNumber);


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

