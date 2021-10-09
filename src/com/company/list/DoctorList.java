package com.company.list;

import com.company.classes.Doctor;
import com.company.interfaces.UserListInterface;
import com.company.iterator.DoctorIterator;

import java.util.ArrayList;
import java.util.List;

public class DoctorList implements UserListInterface<Doctor, DoctorIterator> {
    private List<Doctor> doctorList;

    public DoctorList() {
        this.doctorList = new ArrayList<>();
    }

    @Override
    public void add(Doctor user) {
        doctorList.add(user);
    }

    @Override
    public List<Doctor> getList() {
        return this.doctorList;
    }

    @Override
    public DoctorIterator createIterator() {
        return new DoctorIterator(this);
    }
}
