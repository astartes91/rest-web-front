package org.bibliarij.aurus5assignment.aurus5assignment.service;

import com.google.common.base.Preconditions;
import org.bibliarij.aurus5assignment.aurus5assignment.entity.Category;
import org.bibliarij.aurus5assignment.aurus5assignment.repository.CategoryRepository;
import org.bibliarij.aurus5assignment.aurus5assignment.repository.ProductRepository;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Service for {@link Category} entity
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
@Service
public class CategoryServiceImpl extends EntityServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    /**
     * Update existing entity
     *
     * @should behave correctly
     * @param entity
     * @return
     */
    @Override
    public Category update(Category entity) {
        Preconditions.checkNotNull(entity.getId());

        save(entity);
        return entity;
    }

    /**
     * Delete entity by id
     *
     * @should behave correctly
     * @param id
     */
    @Transactional
    @Override
    public void delete(Long id) {

        productRepository.deleteByCategoryId(id);

        super.delete(id);
    }

    /**
     * Unproxy category
     *
     * @param category
     * @return
     */
    @Override
    public Category unproxy(Category category) {
        Hibernate.initialize(category);
        category = (Category) ((HibernateProxy) category)
                .getHibernateLazyInitializer()
                .getImplementation();
        return category;
    }

    @Override
    protected JpaRepository getRepository() {
        return categoryRepository;
    }
}
