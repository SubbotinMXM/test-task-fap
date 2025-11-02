package factories;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import model.UserData;

import java.util.Random;

@AllArgsConstructor
public class UserDataFactory {
    private final Faker faker;
    private final Random random;

    public UserData createRandomUser() {
        return UserData.builder()
                .firstName(faker.name().firstName() + random.nextInt(1, 99999))
                .email(faker.name().lastName() + random.nextInt(1, 99999) + "@gmail.com")
                .password(faker.name().lastName() + random.nextInt(1, 99999))
                .build();
    }
}

