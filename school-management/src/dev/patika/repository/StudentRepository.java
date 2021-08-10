package dev.patika.repository;

import dev.patika.models.Course;

import java.util.List;

public interface StudentRepository {

    void deleteStudentFromDatabase(int id);
    List<Course> findCoursesOfStudent(int id);

}
