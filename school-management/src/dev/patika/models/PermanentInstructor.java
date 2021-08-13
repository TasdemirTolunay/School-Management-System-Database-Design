package dev.patika.models;

import javax.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor{

    private double fixedSalary;

    public PermanentInstructor(String instructorName, String instructorAdress, String phoneNumber, double fixedSalary) {
        super(instructorName, instructorAdress, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor() {
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" + "instructorName='" + getInstructorName() + '\'' +
                ", instructorAdress='" + getInstructorAdress() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                "fixedSalary=" + fixedSalary + '\'' +
                '}';
    }
}
