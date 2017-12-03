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
public class ProductServiceImpl extends EntityServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    protected JpaRepository getRepository() {
        return repository;
    }

    /**
     * Get all entities
     *
     * @return
     */
    @Transactional
    @Override
    public List getAll() {
        List<Product> result = getRepository().findAll();
        result.forEach(ProductServiceImpl::unproxyCategory);
        return result;
    }

    /**
     * Get entity by id
     *
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Object get(Long id) {
        Product product = (Product) getRepository().findOne(id);
        unproxyCategory(product);
        return product;
    }

    /**
     * Get products by category id
     *
     * @param categoryId
     * @return
     */
    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        List<Product> products = repository.getByCategoryId(categoryId);
        products.forEach(ProductServiceImpl::unproxyCategory);
        return products;
    }

    private static void unproxyCategory(Product product) {
        Category category = product.getCategory();
        Hibernate.initialize(category);
        category = (Category) ((HibernateProxy) category)
                .getHibernateLazyInitializer()
                .getImplementation();
        product.setCategory(category);
    }
}
