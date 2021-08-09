package dev.patika.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String instructorName;
    private String instructorAdress;
    private String phoneNumber;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList = new ArrayList<>();

    public Instructor(String instructorName, String instructorAdress, String phoneNumber) {
        this.instructorName = instructorName;
        this.instructorAdress = instructorAdress;
        this.phoneNumber = phoneNumber;
    }

    public Instructor() {
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorAdress() {
        return instructorAdress;
    }

    public void setInstructorAdress(String instructorAdress) {
        this.instructorAdress = instructorAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorName='" + instructorName + '\'' +
                ", instructorAdress='" + instructorAdress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

}
