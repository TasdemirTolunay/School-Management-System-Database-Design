package dev.patika.controller;

import dev.patika.models.Course;
import dev.patika.models.Student;
import dev.patika.service.StudentService;

import java.util.List;

public class StudentController {

    StudentService studentService = new StudentService();


    public Student findStudent(int id){

        return studentService.findById(id);

    }

    public List<Student> allStudentList(){

        return studentService.findAll();

    }

    public void saveStudent(Student student){

        studentService.saveToDatabase(student);

    }

    public void deleteStudent(int id){

        studentService.deleteStudentFromDatabase(id);

    }

    public void deleteStudent(Student student){

        studentService.deleteFromDatabase(student);

    }

    public void updateStudent(Student student, int id){

        studentService.updateOnDatabase(student,id);

    }

    public List<Course> coursesOfStudent(int id){

        return studentService.findCoursesOfStudent(id);

    }

}
