package dev.patika.service;

import dev.patika.models.Course;
import dev.patika.models.Instructor;
import dev.patika.repository.CrudRepository;
import dev.patika.repository.InstructorRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructorService implements CrudRepository<Instructor>, InstructorRepository {

    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");


    @Override
    public List<Instructor> findAll() {

        return entityManager.createQuery("from Instructor", Instructor.class).getResultList();

    }

    @Override
    public Instructor findById(int id) {

        return entityManager.find(Instructor.class, id);

    }

    @Override
    public void saveToDatabase(Instructor instructor) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(instructor);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }

    @Override
    public void deleteFromDatabase(Instructor instructor) {

        try {
            entityManager.getTransaction().begin();
            Instructor foundInstructor = entityManager.createQuery("from Instructor i where i.phoneNumber =: phoneNumber", Instructor.class).setParameter("phoneNumber",instructor.getPhoneNumber()).getSingleResult();
            entityManager.remove(foundInstructor);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }

    @Override
    public void updateOnDatabase(Instructor instructor, int id) {

        try {
            entityManager.getTransaction().begin();
            Instructor foundInstructor = entityManager.find(Instructor.class,id);
            foundInstructor.setInstructorName(instructor.getInstructorName());
            foundInstructor.setInstructorAdress(instructor.getInstructorAdress());
            foundInstructor.setPhoneNumber(instructor.getPhoneNumber());
            entityManager.merge(foundInstructor);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }

    @Override
    public void deleteInstructorFromDatabase(int id) {

        try {
            entityManager.getTransaction().begin();
            Instructor foundInstructor = entityManager.find(Instructor.class, id);
            entityManager.remove(foundInstructor);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }

    @Override
    public List<Course> findCoursesOfInstructor(int id) {

        return findById(id).getCourseList();

    }
}
