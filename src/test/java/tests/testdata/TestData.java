package tests.testdata;

import com.github.javafaker.Faker;
import utils.RandomRegistrationTestsUtils;

public class TestData {
    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String userEmail = faker.internet().emailAddress();
    public static String failedUserEmail = faker.name().firstName();
    public static String userGender = RandomRegistrationTestsUtils.getRandomGender();
    public static String userNumber = faker.number().digits(10);
    public static String calendarDay = RandomRegistrationTestsUtils.getRandomCalendarDay();  //!!!!!!!!!!!!
    public static String calendarMonth = RandomRegistrationTestsUtils.getRandomMonth(); //!!!!!!!
    public static String calendarYear = String.valueOf(faker.number().numberBetween(1960, 2008));
    public static String userHobby = "Sports";
    public static String userImage = "1.jpg";
    public static String failedUserNumber = faker.lorem().characters(10);
    public static String currentAddress = faker.address().fullAddress();
    public static String userName = "Pureshka s kotletkoy";
    public static String userCity = "Delhi";
    public static String userState = "NCR";
    public static String permanentAddress = "Kastrulka";
    public static String successMessage = "Thanks for submitting the form";
    public static String errorCssKey = "border-color";
    public static String errorCssValue  = "rgb(220, 53, 69)";
}
