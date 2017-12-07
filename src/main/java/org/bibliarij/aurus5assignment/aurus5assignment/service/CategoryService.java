package org.bibliarij.aurus5assignment.aurus5assignment.service;

import org.bibliarij.aurus5assignment.aurus5assignment.entity.Category;

/**
 * Service for {@link Category} entity
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
public interface CategoryService extends EntityService {

    /**
     * Update existing entity
     * @param entity
     * @return
     */
    Category update(Category entity);

    /**
     * Unproxy category
     * @param category
     * @return
     */
    Category unproxy(Category category);
}
