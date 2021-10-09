package com.company.util;

import com.company.constants.DoctorConsts;

import java.util.Locale;
import java.util.Random;

public class DoctorUtil {
    public String generateFirstName() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = DoctorConsts.FIRST_NAME_LENGTH;
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
        int targetStringLength = DoctorConsts.LAST_NAME_LENGTH;
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

        return random.nextInt((DoctorConsts.MAX_AGE_THRESHOLD - DoctorConsts.MIN_AGE_THRESHOLD) + 1) + DoctorConsts.MIN_AGE_THRESHOLD;
    }

    public int generateIdentificationNumber() {
        Random random = new Random();

        return random.nextInt((DoctorConsts.MAX_IDENTIFICATION_NUMBER - DoctorConsts.MIN_IDENTIFICATION_NUMBER) + 1) + DoctorConsts.MIN_IDENTIFICATION_NUMBER;
    }
}
