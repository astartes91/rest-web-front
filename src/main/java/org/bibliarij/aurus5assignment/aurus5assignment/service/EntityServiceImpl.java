package org.bibliarij.aurus5assignment.aurus5assignment.service;

import com.google.common.base.Preconditions;
import org.bibliarij.aurus5assignment.aurus5assignment.entity.Category;
import org.bibliarij.aurus5assignment.aurus5assignment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Generic entity service
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
public abstract class EntityServiceImpl implements EntityService {

    protected abstract JpaRepository getRepository();

    /**
     * Get all entities
     *
     * @return
     */
    @Override
    public List getAll() {
        return getRepository().findAll();
    }

    /**
     * Get entity by id
     *
     * @param id
     * @return
     */
    @Override
    public Object get(Long id) {
        return getRepository().findOne(id);
    }

    /**
     * Create new entity
     *
     * @param entity
     * @return
     */
    @Override
    public Object create(Object entity) {
        Preconditions.checkArgument(entity instanceof Category || entity instanceof Product);
        return getRepository().save(entity);
    }

    /**
     * Update existing entity
     *
     * @param entity
     * @return
     */
    @Override
    public Object update(Object entity) {

        Preconditions.checkArgument(entity instanceof Category || entity instanceof Product);
        if (entity instanceof Category){
            Category category = (Category) entity;
            Preconditions.checkNotNull(category.getId());
        }

        if (entity instanceof Product){
            Product product = (Product) entity;
            Preconditions.checkNotNull(product.getId());
        }

        return getRepository().save(entity);
    }

    /**
     * Delete entity by od
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        getRepository().delete(id);
    }
}
