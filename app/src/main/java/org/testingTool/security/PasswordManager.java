package org.testingTool.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordManager {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!#$%^&*_+-=?";
    private static final String ALL_CHARS = LOWERCASE + UPPERCASE + DIGITS + SPECIAL;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateSecurePassword(int length) {

        String lowercaseChar = randomChar(LOWERCASE);
        String uppercaseChar = randomChar(UPPERCASE);
        String digitChar = randomChar(DIGITS);
        String specialChar = randomChar(SPECIAL);

        String remainingChars = RANDOM.ints(length - 4, 0, ALL_CHARS.length())
                .mapToObj(i -> String.valueOf(ALL_CHARS.charAt(i)))
                .collect(Collectors.joining());

        String combined = lowercaseChar + uppercaseChar + digitChar + specialChar + remainingChars;
        return shuffleString(combined);
    }

    private static String randomChar(String characterSet) {
        return String.valueOf(characterSet.charAt(RANDOM.nextInt(characterSet.length())));
    }

    private static String shuffleString(String input) {
        List<String> chars = Arrays.asList(input.split(""));
        Collections.shuffle(chars, RANDOM);
        return String.join("", chars);
    }

    public static String hashPassword(String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(rawPassword);
    }
}