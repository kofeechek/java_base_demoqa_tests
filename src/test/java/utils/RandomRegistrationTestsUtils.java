package utils;

import com.github.javafaker.Faker;


public class RandomRegistrationTestsUtils {

    Faker faker = new Faker();

    public String getRandomCalendarDay() {
        int randomDay = faker.number().numberBetween(1, 31);
        String randomCalendarDay = String.format("%02d", randomDay);

        return randomCalendarDay;
    }
}