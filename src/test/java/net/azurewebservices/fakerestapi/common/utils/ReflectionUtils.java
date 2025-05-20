package net.azurewebservices.fakerestapi.common.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.reflect.FieldUtils;

@UtilityClass
public class ReflectionUtils {

    @SneakyThrows
    public static void setNullProperty(Object object, String fieldName) {
        FieldUtils.writeField(object, fieldName, null, true);
    }
}
