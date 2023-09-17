package site.nomoreparties.stellarburgers.util;

import com.github.javafaker.Faker;
import site.nomoreparties.stellarburgers.models.registration.request.RequestRegistration;

public class GeneratorUsersRegistration {
    public static RequestRegistration fakeUserWith6Symbol() {
        Faker faker = new Faker();
        return new RequestRegistration()
                .withEmail(faker.internet().emailAddress())
                .withPassword(faker.letterify("1?2?3?"))
                .withName(faker.name().firstName());
    }
    public static RequestRegistration fakeUserWith7Symbol() {
        Faker faker = new Faker();
        return new RequestRegistration()
                .withEmail(faker.internet().emailAddress())
                .withPassword(faker.letterify("1?2?3?7"))
                .withName(faker.name().firstName());
    }
    public static RequestRegistration fakeUserWith5Symbol() {
        Faker faker = new Faker();
        return new RequestRegistration()
                .withEmail(faker.internet().emailAddress())
                .withPassword(faker.letterify("1?2?3"))
                .withName(faker.name().firstName());
    }
    public static RequestRegistration fakeUser() {
        Faker faker = new Faker();
        return new RequestRegistration()
                .withEmail(faker.internet().emailAddress())
                .withPassword(faker.letterify("1?2?3?4?5?6?7?8?9?10"))
                .withName(faker.name().firstName());
    }
}
