package dev.patika.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courseList = new ArrayList<>();
}
