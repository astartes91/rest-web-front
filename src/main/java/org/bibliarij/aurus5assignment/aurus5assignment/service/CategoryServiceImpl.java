package org.bibliarij.aurus5assignment.aurus5assignment.service;

import org.bibliarij.aurus5assignment.aurus5assignment.entity.Category;
import org.bibliarij.aurus5assignment.aurus5assignment.repository.CategoryRepository;
import org.bibliarij.aurus5assignment.aurus5assignment.repository.ProductRepository;
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
public class CategoryServiceImpl extends EntityServiceImpl {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    /**
     * Delete entity by od
     *
     * @param id
     */
    @Transactional
    @Override
    public void delete(Long id) {

        productRepository.deleteByCategoryId(id);

        super.delete(id);
    }

    @Override
    protected JpaRepository getRepository() {
        return categoryRepository;
    }
}
