package org.bibliarij.restwithwebfront.service;

import com.google.common.base.Preconditions;
import org.bibliarij.restwithwebfront.entity.Product;
import org.bibliarij.restwithwebfront.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Service for {@link Product} entity
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
@Service
public class ProductServiceImpl extends EntityServiceImpl implements ProductService {


    private CategoryService categoryService;
    private ProductRepository repository;

    @Autowired
    public ProductServiceImpl(CategoryService categoryService, ProductRepository repository) {
        this.categoryService = categoryService;
        this.repository = repository;
    }

    @Override
    protected JpaRepository getRepository() {
        return repository;
    }

    /**
     * Get all entities
     *
     * @should return correct result
     * @return
     */
    @Transactional
    @Override
    public List getAll() {
        List<Product> result = repository.findAll();
        result.stream().peek(product -> product.setCategory(categoryService.unproxy(product.getCategory()))).findAny();
        return result;
    }

    /**
     * Get entity by id
     *
     * @should return correct result
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Object get(Long id) {
        Product product = repository.findOne(id);
        product.setCategory(categoryService.unproxy(product.getCategory()));
        return product;
    }

    /**
     * Create new entity
     *
     * @should return correct result
     * @param entity
     * @return
     */
    @Override
    public Product create(Product entity) {
        entity.setAdditionDate(new Date());
        save(entity);
        return entity;
    }

    /**
     * Update existing entity
     *
     * @should return correct result
     * @param entity
     * @return
     */
    @Override
    public Product update(Product entity) {
        Long id = entity.getId();
        Preconditions.checkNotNull(id);
        Product entityFromDb = repository.findOne(id);
        entity.setAdditionDate(entityFromDb.getAdditionDate());

        save(entity);
        return entity;
    }

    /**
     * Get products by category id
     *
     * @should return correct result
     * @param categoryId
     * @return
     */
    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        List<Product> products = repository.getByCategoryId(categoryId);
        products.stream()
                .peek(product -> product.setCategory(categoryService.unproxy(product.getCategory())))
                .findAny();
        return products;
    }
}
