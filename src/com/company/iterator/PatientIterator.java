package com.company.iterator;

import com.company.classes.Patient;
import com.company.list.PatientList;
import com.company.interfaces.IteratorInterface;

public class PatientIterator implements IteratorInterface<Patient> {
    private PatientList patientList;
    private int index;

    public PatientIterator(PatientList patientList) {
        this.patientList = patientList;
    }

    @Override
    public boolean hasNext() {
        return (index < patientList.getList().size());
    }

    @Override
    public Patient current() {
        return patientList.getList().get(index);
    }

    @Override
    public void next() {
        index++;
    }
}