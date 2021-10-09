package com.company.util;

import com.company.constants.PatientConsts;

import java.util.Locale;
import java.util.Random;

public class PatientUtil {
    public String generateFirstName() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = PatientConsts.FIRST_NAME_LENGTH;
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            stringBuilder.append((char) randomLimitedInt);
        }
        String generatedString = stringBuilder.substring(0, 1).toUpperCase(Locale.ROOT) + stringBuilder.substring(1);

        return generatedString;
    }

    public String generateLastName() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = PatientConsts.LAST_NAME_LENGTH;
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            stringBuilder.append((char) randomLimitedInt);
        }
        String generatedString = stringBuilder.substring(0, 1).toUpperCase(Locale.ROOT) + stringBuilder.substring(1);

        return generatedString;
    }

    public int generateAge() {
        Random random = new Random();

        return random.nextInt((PatientConsts.MAX_AGE_THRESHOLD - PatientConsts.MIN_AGE_THRESHOLD) + 1) + PatientConsts.MIN_AGE_THRESHOLD;
    }

    public String generateReason() {
        String[] reasons = {PatientConsts.CONSULTATION, PatientConsts.TREATMENT, PatientConsts.PRESCRIPTION};
        int randomString = (new Random()).nextInt(reasons.length);

        return reasons[randomString];
    }
}
