package dev.patika.controller;

import dev.patika.models.Course;
import dev.patika.models.Instructor;
import dev.patika.service.InstructorService;

import java.util.List;

public class InstructorController {

    InstructorService instructorService = new InstructorService();


    public Instructor findInstructor(int id){

        return instructorService.findById(id);

    }

    public List<Instructor> allInstructorList(){

        return instructorService.findAll();

    }

    public void saveInstructor(Instructor instructor){

        instructorService.saveToDatabase(instructor);

    }

    public void deleteInstructor(int id){

        instructorService.deleteInstructorFromDatabase(id);

    }

    public void deleteInstructor(Instructor instructor){

        instructorService.deleteFromDatabase(instructor);

    }

    public void updateInstructor(Instructor instructor, int id){

        instructorService.updateOnDatabase(instructor, id);

    }

    public List<Course> coursesOfInstructor(int id){

        return instructorService.findCoursesOfInstructor(id);

    }

}
