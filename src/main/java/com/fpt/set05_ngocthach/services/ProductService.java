package com.fpt.set05_ngocthach.services;

import com.fpt.set05_ngocthach.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProductService implements IProductService {
    private final EntityManager entityManager;

    public ProductService() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<Product> getAll() {
        return entityManager.createQuery("SELECT e FROM Product e", Product.class).getResultList();
    }

    @Override
    public List<Product> getAll(String keyword) {

        var query = entityManager.createQuery("SELECT e FROM Product e WHERE e.productname LIKE :keyword", Product.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }

    @Override
    public Product getProductById(String id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public boolean addProduct(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProduct(String id) {
        try {
            entityManager.getTransaction().begin();
            Product product = entityManager.find(Product.class, id);
            entityManager.remove(product);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        }
    }
}
