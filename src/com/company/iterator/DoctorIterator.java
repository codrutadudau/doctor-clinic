package com.company.iterator;

import com.company.classes.Doctor;
import com.company.interfaces.IteratorInterface;
import com.company.list.DoctorList;

public class DoctorIterator implements IteratorInterface<Doctor> {
    private DoctorList doctorList;
    private int index;

    public DoctorIterator(DoctorList doctorList) {
        this.doctorList = doctorList;
    }

    @Override
    public boolean hasNext() {
        return (index < doctorList.getList().size());
    }

    @Override
    public Doctor current() {
        return doctorList.getList().get(index);
    }

    @Override
    public void next() {
        index++;
    }
}