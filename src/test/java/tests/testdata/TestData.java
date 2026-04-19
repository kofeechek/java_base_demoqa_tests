package tests.testdata;

import com.github.javafaker.Faker;
import utils.RandomRegistrationTestsUtils;

public class TestData {
    public static Faker faker = new Faker();
    RandomRegistrationTestsUtils randomRegistrationTestsUtils = new RandomRegistrationTestsUtils();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String calendarDay = randomRegistrationTestsUtils.getRandomCalendarDay();
    public String calendarMonth = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public String calendarYear = String.valueOf(faker.number().numberBetween(1960, 2008));
    public String userGender = faker.options().option("Male", "Female", "Other");
    public String failedUserEmail = faker.name().firstName();
    public String userNumber = faker.number().digits(10);
    public String userHobby = "Sports";
    public String userImage = "1.jpg";
    public String failedUserNumber = faker.lorem().characters(10);
    public String currentAddress = faker.address().fullAddress();
    public String userName = "Pureshka s kotletkoy";
    public String userCity = "Delhi";
    public String userState = "NCR";
    public String permanentAddress = "Kastrulka";
    public String successMessage = "Thanks for submitting the form";
    public String errorCssKey = "border-color";
    public String errorCssValue  = "rgb(220, 53, 69)";
}
