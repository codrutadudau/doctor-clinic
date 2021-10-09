package com.company.constants;

import java.util.HashMap;
import java.util.Map;

public class PatientConstants {
    public static final int POOL_SIZE = 100;
    public static final int FIRST_NAME_LENGTH = 5;
    public static final int LAST_NAME_LENGTH = 4;
    public static final int MIN_AGE_THRESHOLD = 0;
    public static final int MAX_AGE_THRESHOLD = 85;
//    public static final String[] REASONS = {"Consultation", "Treatment", "Prescription"};
    public static final int CHILDREN_MAX_AGE_THRESHOLD = 1;
    public static final int PUPIL_MAX_AGE_THRESHOLD = 7;
    public static final int STUDENT_MAX_AGE_THRESHOLD = 18;
    public static final String ADULT = "Adult";
    public static final String STUDENT = "Student";
    public static final String PUPIL = "Pupil";
    public static final String CHILDREN = "Children";

    public static final String CONSULTATION = "Consultation";
    public static final String PRESCRIPTION = "Prescription";
    public static final String TREATMENT = "Treatment";

    public static Map<String, Integer> getReasonParams(String reason) {
        Map <String, Integer> reasonParams = new HashMap<>();
        int duration;
        int fee;

        switch (reason) {
            case PRESCRIPTION:
                duration = 20;
                fee = 20;
                break;
            case TREATMENT:
                duration = 40;
                fee = 35;
                break;
            case CONSULTATION:
            default:
                duration = 30;
                fee = 50;
        }

        reasonParams.put("duration", duration);
        reasonParams.put("fee", fee);

        return reasonParams;
    }
}


