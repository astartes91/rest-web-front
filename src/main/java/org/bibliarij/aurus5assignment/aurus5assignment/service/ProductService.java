package org.bibliarij.aurus5assignment.aurus5assignment.service;

import org.bibliarij.aurus5assignment.aurus5assignment.entity.Product;

import java.util.List;

/**
 * Service for {{@link Product}} entity
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
public interface ProductService extends EntityService {

    /**
     * Get products by category id
     * @param categoryId
     * @return
     */
    List<Product> getProductsByCategoryId(Long categoryId);
}
