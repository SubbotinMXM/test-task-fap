package extension;

import annotation.RandomUser;
import com.github.javafaker.Faker;
import model.UserData;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.Random;

public class RandomUserExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(RandomUser.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Class<?> type = parameterContext.getParameter().getType();
        if (type.equals(UserData.class)) {
            Random random = new Random();
            Faker faker = new Faker();
            return UserData.builder()
                    .firstName(faker.name().firstName() + random.nextInt(1, 99999))
                    .email(faker.name().lastName() + random.nextInt(1, 99999) + "@gmail.com")
                    .password(faker.name().lastName() + random.nextInt(1, 99999))
                    .build();
        }
        throw new ParameterResolutionException("Пользователь не был сгенерирован");
    }
}
