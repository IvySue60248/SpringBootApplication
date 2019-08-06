package com.ivy.springboothello.javax.validation;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {

    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");
    public static boolean isMobile(String value) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }
        Matcher m = mobile_pattern.matcher(value);
        return m.matches();
    }
}
