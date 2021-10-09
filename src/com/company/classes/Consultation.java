package com.company.classes;

import com.company.constants.PatientConstants;

public class Consultation {
    private Patient beneficiary;
    private Doctor consultant;
    private int duration;
    private int fee;

    public Patient getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Patient beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Doctor getConsultant() {
        return consultant;
    }

    public void setConsultant(Doctor consultant) {
        this.consultant = consultant;
    }

    public int getDuration() {
        if (this.getBeneficiary() == null) {
            return 0;
        }

        return PatientConstants.getReasonParams(this.getBeneficiary().getReason()).get("duration");
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFee() {
        if (this.getBeneficiary() == null) {
            return 0;
        }

        return PatientConstants.getReasonParams(this.getBeneficiary().getReason()).get("fee");
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
