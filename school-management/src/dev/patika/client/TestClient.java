package dev.patika.client;

import dev.patika.controller.CourseController;
import dev.patika.controller.InstructorController;
import dev.patika.controller.StudentController;
import dev.patika.models.*;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class TestClient {

    public static void main(String[] args) {

        if(checkDatabase() == 0){
            SaveTestData();
        }

        StudentController studentController = new StudentController();
        CourseController courseController = new CourseController();
        InstructorController instructorController = new InstructorController();

        System.out.println("********All Student List********");
        List<Student> allStudent = studentController.allStudentList();
        for (Student student : allStudent) {
            System.out.println(student);
        }

        System.out.println("********All Instructor List*******");
        List<Instructor> listInstructor = instructorController.allInstructorList();
        for (Instructor instructor : listInstructor) {
            System.out.println(instructor);
        }

        System.out.println("**********All Course List**********");
        List<Course> listCourses = courseController.allCourseList();
        for (Course course : listCourses) {
            System.out.println(course);
        }

        /*
        System.out.println("**********Save Student************");
        Student saveTestStudent = new Student("Ahmet", LocalDate.of(1990, Month.MAY,22),"Trabzon", "Male");
        studentController.saveStudent(saveTestStudent);
        System.out.println("Yeni öğrenci kaydı gerçekleşti.....");
         */

        System.out.println("******Find Student with id******");
        Student student = studentController.findStudent(2);
        System.out.println(student);

        System.out.println("********Student's courses***********");
        List<Course> coursesOfStudent = studentController.coursesOfStudent(1);
        for (Course course : coursesOfStudent) {

            System.out.println(course);

        }

        System.out.println("*******Find Course with courseId*******");
        Course findCourse = courseController.findCourse(2);
        System.out.println(findCourse);

        System.out.println("**********Course's Instructor**********");
        Instructor instructor = courseController.instructorOfCourse(1);
        System.out.println(instructor);

        System.out.println("*********Find Instructor with id*********");
        Instructor findInstructor = instructorController.findInstructor(3);
        System.out.println(findInstructor);

    }

    private static int checkDatabase() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        return em.createQuery("from Student ", Student.class).getResultList().size();
    }

    private static void SaveTestData() {

        Student student1 = new Student("Tolunay", LocalDate.of(1996, Month.FEBRUARY, 12), "Ankara", "Male");
        Student student2 = new Student("Wahid",LocalDate.of(1996, Month.MARCH, 8), "Jawzjan", "Male");
        Student student3 = new Student("Guven", LocalDate.of(1996, Month.OCTOBER, 23), "Ankara", "Male");
        Student student4 = new Student("Ayse", LocalDate.of(1990, Month.APRIL, 15), "Hatay", "Female");
        Student student5 = new Student("Dilara", LocalDate.of(1994, Month.SEPTEMBER, 29), "Samsun", "Female");
        Student student6 = new Student("Victoria", LocalDate.of(1975, Month.JANUARY, 5), "Dublin", "Female");
        Student student7 = new Student("Jack", LocalDate.of(1992, Month.JUNE, 17), "New york", "Male");

        Course course1 = new Course("113.Java Spring Bootcamp", "J-00113",20);
        Course course2 = new Course("255.React Bootcamp", "R-00255",14);
        Course course3 = new Course("243.Android Bootcamp", "A-00243",25);

        Instructor instructor1 = new PermanentInstructor("Koray Guney", "Istanbul", "+905055055050", 5000.0);
        Instructor instructor2 = new VisitingResearcher("Joseph Delgadillo", "Seattle", "+15161488135", 200.0);
        Instructor instructor3 = new PermanentInstructor("Denis Panjuta", "Madrid", "+3484102287", 8250.0);

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);
        course3.setInstructor(instructor3);

        course1.getStudents().add(student1);
        course1.getStudents().add(student2);
        course2.getStudents().add(student3);
        course2.getStudents().add(student4);
        course3.getStudents().add(student5);
        course3.getStudents().add(student6);
        course1.getStudents().add(student7);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();
            em.persist(student1);
            em.persist(student2);
            em.persist(student3);
            em.persist(student4);
            em.persist(student5);
            em.persist(student6);
            em.persist(student7);

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);

            em.persist(instructor1);
            em.persist(instructor2);
            em.persist(instructor3);

            em.getTransaction().commit();

            System.out.println("All Data Persisted.......");

        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(em);
        }

    }
}
