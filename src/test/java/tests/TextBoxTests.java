package tests;

import org.junit.jupiter.api.Test;
import tests.testdata.TestData;


public class TextBoxTests extends TestBase {

TestData testData = new TestData();

    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(testData.userName);
        textBoxPage.typeUserEmail(testData.userEmail);
        textBoxPage.typeCurrentAddress(testData.currentAddress);
        textBoxPage.typePermanentAddress(testData.permanentAddress);

        textBoxPage.submitForm();

        textBoxPage.checkField("name", testData.userName);
        textBoxPage.checkField("email", testData.userEmail);
        textBoxPage.checkField("currentAddress", testData.currentAddress);
        textBoxPage.checkField("permanentAddress", testData.permanentAddress);
    }

    @Test
    void failedFillFormTest() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(testData.userName);
        textBoxPage.typeUserEmail(testData.failedUserEmail);
        textBoxPage.typeCurrentAddress(testData.currentAddress);
        textBoxPage.typePermanentAddress(testData.permanentAddress);

        textBoxPage.submitForm();

        textBoxPage.checkFailedUserEmail();
    }
}


