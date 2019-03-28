package com.endava.demo.dao.impl;

import com.endava.demo.dao.InternDAO;
import com.endava.demo.entity.Intern;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InternDAOImpl implements InternDAO {


    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    @PersistenceContext()
    EntityManager em = emf.createEntityManager();


    @Override
    public List<Intern> findAll() {
        TypedQuery<Intern> query = (TypedQuery<Intern>) em.createNativeQuery("SELECT * FROM intern ORDER BY id", Intern.class);

        return query.getResultList();

    }

    @Override
    public void save(Intern intern) {
        em.getTransaction().begin();
        em.persist(intern);
        em.getTransaction().commit();
    }

    @Override
    public void update(Intern intern) {

        TypedQuery<Intern> query = (TypedQuery<Intern>) em.createNativeQuery("SELECT * from intern ", Intern.class);
        ArrayList<Intern> list = (ArrayList<Intern>) query.getResultList();
        //in case somebody deleted the object before update
        if (list.isEmpty()) {
            em.getTransaction().begin();
            em.merge(intern);
            em.getTransaction().commit();

        } else {

            intern.setId(intern.getId());
        }

        for (Intern i : list) {
            if (intern.getId() == i.getId()) {
                em.getTransaction().begin();
                em.merge(intern);
                em.getTransaction().commit();
            }

        }


    }


    @Override
    public void delete(int id) {
        TypedQuery<Intern> query = (TypedQuery<Intern>) em.createNativeQuery("SELECT * from intern", Intern.class);
        ArrayList<Intern> list = (ArrayList<Intern>) query.getResultList();
        for (Intern i : new ArrayList<>(list)) {
            if (i.getId() == id) {
                em.getTransaction().begin();
                em.remove(i);
                em.getTransaction().commit();
            }

        }


    }

    @Override
    public Intern getObjectForUpdate(int id) {
        Intern intern = new Intern();
        TypedQuery<Intern> query = (TypedQuery<Intern>) em.createNativeQuery("SELECT * from intern", Intern.class);
        ArrayList<Intern> list = (ArrayList<Intern>) query.getResultList();
        for (Intern i : new ArrayList<>(list)) {
            if (i.getId() == id) {

                intern.setId(i.getId());
                intern.setName(i.getName());
                intern.setAge(i.getAge());
                intern.setStream(i.getStream());


                return intern;
            }
        }
        return null;
    }

}


