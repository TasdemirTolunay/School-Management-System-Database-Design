package dev.patika.repository;

import dev.patika.models.Instructor;

public interface CourseRepository {

    void deleteCourseFromDatabase(int id);
    Instructor findInstructorOfCourse(int id);

}
