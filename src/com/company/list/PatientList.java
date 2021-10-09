package com.company.list;

import com.company.classes.Patient;
import com.company.interfaces.UserListInterface;
import com.company.iterator.PatientIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PatientList implements UserListInterface<Patient, PatientIterator>, Serializable {
    private List<Patient> patientList;

    public PatientList() {
        this.patientList = new ArrayList<>();
    }

    @Override
    public void add(Patient user) {
        patientList.add(user);
    }

    @Override
    public List<Patient> getList() {
        return this.patientList;
    }

    @Override
    public PatientIterator createIterator() {
        return new PatientIterator(this);
    }
}
