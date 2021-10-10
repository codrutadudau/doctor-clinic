package com.company;

import com.company.builder.Director;
import com.company.builder.DoctorBuilder;
import com.company.builder.PatientBuilder;
import com.company.classes.Consultation;
import com.company.classes.Doctor;
import com.company.classes.Patient;
import com.company.classes.Report;
import com.company.constants.ConsultationConstants;
import com.company.iterator.PatientIterator;
import com.company.list.DoctorList;
import com.company.constants.DoctorConstants;
import com.company.constants.PatientConstants;
import com.company.iterator.DoctorIterator;
import com.company.list.PatientList;
import com.company.util.FileProcessor;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Director director = new Director();
        DoctorList doctorList = new DoctorList();
        PatientList patientList = new PatientList();
        FileProcessor fileProcessor = new FileProcessor();

        if (fileProcessor.exists("./json/doctor.json")) {
            JsonReader doctorReader = fileProcessor.readDataFromFile("./json/doctor.json");
            doctorList = new Gson().fromJson(doctorReader, DoctorList.class);
        } else {
            DoctorBuilder doctorBuilder = new DoctorBuilder();

            ArrayList<Integer> identificationNumbersList = new ArrayList<>();
            for (int i = 0; i < DoctorConstants.STAFF_SIZE; i++) {
                doctorList.add(director.buildDoctor(doctorBuilder, identificationNumbersList));
            }

            String doctorListJson = new Gson().toJson(doctorList);
            fileProcessor.writeDataToFile(doctorListJson, "./json/doctor.json");
        }

        if (fileProcessor.exists("./json/patient.json")) {
            JsonReader patientReader = fileProcessor.readDataFromFile("./json/patient.json");
            patientList = new Gson().fromJson(patientReader, PatientList.class);
        } else {
            PatientBuilder patientBuilder = new PatientBuilder();

            for (int i = 0; i < PatientConstants.POOL_SIZE; i++) {
                patientList.add(director.buildPatient(patientBuilder));
            }

            String patientListJson = new Gson().toJson(patientList);
            fileProcessor.writeDataToFile(patientListJson, "./json/patient.json");
        }

        System.out.println("List of Doctors\n");
        DoctorIterator doctorIterator = doctorList.createIterator();
        while (doctorIterator.hasNext()) {
            System.out.println("Doctor: " + doctorIterator.current());
            doctorIterator.next();
        }

        System.out.println(" ");
        System.out.println("List of Patients\n");
        PatientIterator patientIterator = patientList.createIterator();
        HashMap<String, Integer> patientGroupsByAgeCategory = new HashMap<>();
        while (patientIterator.hasNext()) {
            if (patientGroupsByAgeCategory.containsKey(patientIterator.current().getAgeCategory())) {
                patientGroupsByAgeCategory.put(patientIterator.current().getAgeCategory(), patientGroupsByAgeCategory.get(patientIterator.current().getAgeCategory()) + 1);
            } else {
                patientGroupsByAgeCategory.put(patientIterator.current().getAgeCategory(), 1);
            }

            System.out.println("Patient: " + patientIterator.current());
            patientIterator.next();
        }

        System.out.println(" ");
        System.out.println("Categories of Patients Based on their Age Category\n");
        System.out.println(patientGroupsByAgeCategory);
        HashMap<Integer, Report> doctorReports = new HashMap<>();
        Queue<Doctor> availableDoctors = new LinkedList<>(doctorList.getList());
        List<Patient> notConsultedPatients = new ArrayList<>();
        for (Patient patient : patientList.getList()) {
            if (!availableDoctors.isEmpty()) {
                int queueSize = availableDoctors.size();
                Doctor doctor = availableDoctors.peek();
                Report report = new Report();

                Consultation consultation = new Consultation();
                consultation.setConsultant(doctor);
                consultation.setBeneficiary(patient);

                int identificationNumber = doctor.getIdentificationNumber();
                if (doctorReports.containsKey(identificationNumber)) {
                    report = doctorReports.get(identificationNumber);
                } else {
                    doctorReports.put(identificationNumber, report);
                }

                int shiftDurationLeftInHours = queueSize % 2 == 0 ?
                        DoctorConstants.DAILY_SHIFT_LENGTH_IN_HOURS :
                        ConsultationConstants.INTERVAL_AMOUNT_IN_HOURS - DoctorConstants.DAILY_SHIFT_LENGTH_IN_HOURS;
                if (report.getDuration() + consultation.getDuration() > shiftDurationLeftInHours * 60) {
                    availableDoctors.remove();
                    doctor = availableDoctors.peek();
                    if (doctor == null) {
                        notConsultedPatients.add(patient);
                        continue;
                    }

                    report = new Report();
                    identificationNumber = doctor.getIdentificationNumber();
                    doctorReports.put(identificationNumber, report);
                }

                report.setDoctor(doctor);
                report.setNumberOfPatients(report.getNumberOfPatients() + 1);
                report.setDuration(report.getDuration() + consultation.getDuration());
                report.setTotalBilledAmount(report.getTotalBilledAmount() + consultation.getFee());
                doctorReports.put(identificationNumber, report);
            } else {
                notConsultedPatients.add(patient);
            }
        }

        System.out.println(" ");
        System.out.println("Summary of doctors, the number of patients consulted and the total amount billed\n");
        for (Map.Entry<Integer, Report> entry : doctorReports.entrySet()) {
            Report report = entry.getValue();
            Doctor doctor = report.getDoctor();
            System.out.println(doctor.getFirstName() + ", " + doctor.getLastName() + " - " + doctor.getIdentificationNumber() + ": " + report.getNumberOfPatients() + " patients, " + report.getDuration() + "minutes, " + report.getTotalBilledAmount() + " RON");
        }

        System.out.println(" ");
        System.out.println("List of patients which were not consulted\n");
        for (Patient patient : notConsultedPatients) {
            System.out.println(patient.getFirstName() + ", " + patient.getLastName() + ", " + patient.getAge() + " years, " + patient.getReason());
        }
    }
}
