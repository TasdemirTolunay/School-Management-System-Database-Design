package dev.patika.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String studentName;
    private LocalDate studentBirthDate;
    private String studentAddress;
    private String studentGender;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    public Student(String studentName, LocalDate studentBirthDate, String studentAddress, String studentGender) {
        this.studentName = studentName;
        this.studentBirthDate = studentBirthDate;
        this.studentAddress = studentAddress;
        this.studentGender = studentGender;
    }

    public Student() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getStudentBirthDate() {
        return studentBirthDate;
    }

    public void setStudentBirthDate(LocalDate studentBirthDate) {
        this.studentBirthDate = studentBirthDate;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + studentName + '\'' +
                ", birthDate=" + studentBirthDate +
                ", address='" + studentAddress + '\'' +
                ", gender='" + studentGender + '\'' +
                '}';
    }

}
