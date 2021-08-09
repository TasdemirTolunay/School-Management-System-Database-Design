package dev.patika.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private String courseCode;
    private double creditScore;

    @ManyToOne
    private Instructor instructor;

    @ManyToMany
    private List<Student> students =new ArrayList<>();


}
