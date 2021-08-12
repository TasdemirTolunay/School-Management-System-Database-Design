package dev.patika.controller;

import dev.patika.models.Course;
import dev.patika.models.Instructor;
import dev.patika.service.CourseService;

import java.util.List;

public class CourseController {

    CourseService courseService = new CourseService();


    public Course findCourse(int courseId){

        return courseService.findById(courseId);

    }

    public List<Course> allCourseList(){

        return courseService.findAll();

    }

    public void saveCourse(Course course){

        courseService.saveToDatabase(course);

    }

    public void deleteCourse(int id){

        courseService.deleteCourseFromDatabase(id);

    }

    public void deleteCourse(Course course){

        courseService.deleteFromDatabase(course);

    }

    public void updateCourse(Course course, int id){

        courseService.updateOnDatabase(course,id);

    }

    public Instructor instructorOfCourse(int id){

        return courseService.findInstructorOfCourse(id);

    }

}
