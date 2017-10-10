/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.donc.dao;

import br.senac.donc.model.Vereador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author danilosetubal
 */
public class VereadorDAO {
    
    private static VereadorDAO instance;
    protected EntityManager entityManager;
    
    public static VereadorDAO getInstance() {
        if (instance == null) {
            instance = new VereadorDAO();
        }
        return instance;
    }
    
    private VereadorDAO() {
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("doncPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        
        return entityManager;
    }
    
    public Vereador getById(final int id) {
        return entityManager.find(Vereador.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Vereador> findAll() {
        return entityManager.createQuery( "FROM " + Vereador.class.getName()).getResultList();
    }
    
    public void persist(Vereador vereador) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vereador);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(Vereador vereador) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(vereador);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Vereador vereador) {
        try {
            entityManager.getTransaction().begin();
            vereador = entityManager.find(Vereador.class, vereador.getId());
            entityManager.remove(vereador);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById(final int id) {
        try {
            Vereador vereador = getById(id);
            remove(vereador);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
