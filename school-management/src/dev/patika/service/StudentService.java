package dev.patika.service;

import dev.patika.models.Course;
import dev.patika.models.Student;
import dev.patika.repository.CrudRepository;
import dev.patika.repository.StudentRepository;
import dev.patika.utils.EntityManagerUtils;


import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student>, StudentRepository {

    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void saveToDatabase(Student student) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }

    @Override
    public void deleteFromDatabase(Student student) {

        try {
            entityManager.getTransaction().begin();
            Student foundStudent = entityManager.createQuery("from Student s where s.studentName =: studentName", Student.class).setParameter("studentName", student.getStudentName()).getSingleResult();
            entityManager.remove(foundStudent);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }

    @Override
    public void updateOnDatabase(Student student, int id) {

        try {
            entityManager.getTransaction().begin();
            Student foundStudent = entityManager.find(Student.class, id);
            foundStudent.setStudentAddress(student.getStudentAddress());
            foundStudent.setStudentName(student.getStudentName());
            foundStudent.setStudentBirthDate(student.getStudentBirthDate());
            foundStudent.setStudentGender(student.getStudentGender());
            entityManager.merge(foundStudent);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }

    @Override
    public void deleteStudentFromDatabase(int id) {

        try {
            entityManager.getTransaction().begin();
            Student foundStudent = entityManager.find(Student.class, id);
            entityManager.remove(foundStudent);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }

    @Override
    public List<Course> findCoursesOfStudent(int id) {
        return findById(id).getCourses();
    }
}
