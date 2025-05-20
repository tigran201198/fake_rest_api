package net.azurewebservices.fakerestapi.common.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;

@UtilityClass
public class RandomUtils {

    public static int randomInt() {
        return new SecureRandom().nextInt();
    }

    public static int randomCollectionIndex(int size) {
        return new SecureRandom().nextInt(0, size - 1);
    }

    public static String randomAlphabeticString(int count) {
        return RandomStringUtils.secure().nextAlphabetic(count);
    }
}
