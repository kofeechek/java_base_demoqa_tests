package utils;

import com.github.javafaker.Faker;


public class RandomRegistrationTestsUtils {

    Faker faker = new Faker();

    public String getRandomCalendarDay() {
        int randomDay = faker.number().numberBetween(1, 28);
        String randomCalendarDay = String.format("%02d", randomDay);

        return randomCalendarDay;
    }


    public String getRandomCity(String userState) {
        switch (userState) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return userState;
        }

    }

}