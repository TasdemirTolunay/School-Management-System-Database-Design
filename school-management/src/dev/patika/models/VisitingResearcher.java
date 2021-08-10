package dev.patika.models;

import javax.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor{

    private double hourlySalary;

    public VisitingResearcher(String instructorName, String instructorAdress, String phoneNumber, double hourlySalary) {
        super(instructorName, instructorAdress, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher() {
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }

}
