package org.bibliarij.aurus5assignment.aurus5assignment.service;

import org.bibliarij.aurus5assignment.aurus5assignment.entity.Category;
import org.bibliarij.aurus5assignment.aurus5assignment.entity.Product;
import org.bibliarij.aurus5assignment.aurus5assignment.repository.ProductRepository;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for {@link Product} entity
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
@Service
public class ProductServiceImpl extends EntityServiceImpl {

    @Autowired
    private ProductRepository repository;

    @Override
    protected JpaRepository getRepository() {
        return repository;
    }

    /**
     * Find all entities
     *
     * @return
     */
    @Transactional
    @Override
    public List findAll() {
        List<Product> result = getRepository().findAll();
        result.forEach(
                product -> {
                    Category category = product.getCategory();
                    Hibernate.initialize(category);
                    category = (Category) ((HibernateProxy) category)
                            .getHibernateLazyInitializer()
                            .getImplementation();
                    product.setCategory(category);
                }
        );
        return result;
    }
}
