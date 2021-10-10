package com.company.classes;

public class Report {
    private Doctor doctor;
    private int totalBilledAmount = 0;
    private int numberOfPatients = 0;
    private int duration = 0;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getTotalBilledAmount() {
        return totalBilledAmount;
    }

    public void setTotalBilledAmount(int totalBilledAmount) {
        this.totalBilledAmount = totalBilledAmount;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }

    public void setNumberOfPatients(int numberOfPatients) {
        this.numberOfPatients = numberOfPatients;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
