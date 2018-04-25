package org.bibliarij.restwithwebfront.service;

import org.bibliarij.restwithwebfront.entity.Product;

import java.util.List;

/**
 * Service for {@link Product} entity
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
public interface ProductService extends EntityService {

    /**
     * Create new entity
     * @param entity
     * @return
     */
    Product create(Product entity);

    /**
     * Update existing entity
     * @param entity
     * @return
     */
    Product update(Product entity);

    /**
     * Get products by category id
     * @param categoryId
     * @return
     */
    List<Product> getProductsByCategoryId(Long categoryId);
}
