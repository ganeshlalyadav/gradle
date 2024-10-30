package org.example.repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entity.Product;

import java.util.List;

public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(Product product) {
        em.persist(product);
    }

    public Product find(Long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Transactional
    public void delete(Long id) {
        Product product = find(id);
        if (product != null) {
            em.remove(product);
        }
    }
}
