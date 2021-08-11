package dev.patika.service;

import dev.patika.models.Course;
import dev.patika.models.Instructor;
import dev.patika.repository.CourseRepository;
import dev.patika.repository.CrudRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;


public class CourseService implements CrudRepository<Course>, CourseRepository {

    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public void deleteCourseFromDatabase(int id) {
        try {
            entityManager.getTransaction().begin();
            Course foundCourse = entityManager.find(Course.class, id);
            entityManager.remove(foundCourse);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public Instructor findInstructorOfCourse(int id) {
        return findById(id).getInstructor();
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void saveToDatabase(Course course) {

        try{
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }

    @Override
    public void deleteFromDatabase(Course course) {

        try {
            entityManager.getTransaction().begin();
            Course foundCourse = entityManager.createQuery("from Course c where c.courseCode =: courseCode", Course.class).setParameter("courseCode", course.getCourseCode()).getSingleResult();
            entityManager.remove(foundCourse);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }

    @Override
    public void updateOnDatabase(Course course, int id) {

        try {
            entityManager.getTransaction().begin();
            Course updateCourse = entityManager.find(Course.class, id);
            updateCourse.setCourseName(course.getCourseName());
            updateCourse.setCourseCode(course.getCourseCode());
            updateCourse.setCreditScore(course.getCreditScore());
            entityManager.merge(updateCourse);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }

}
