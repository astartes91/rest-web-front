package org.bibliarij.restwithwebfront.service;

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
     * @should behave correctly
     * @return
     */
    @Override
    public List getAll() {
        return getRepository().findAll();
    }

    /**
     * Get entity by id
     *
     * @should behave correctly
     * @param id
     * @return
     */
    @Override
    public Object get(Long id) {
        return getRepository().findOne(id);
    }

    /**
     * Save entity
     *
     * @should behave correctly
     * @param entity
     * @return
     */
    @Override
    public Object save(Object entity) {
        return getRepository().save(entity);
    }

    /**
     * Delete entity by id
     *
     * @should behave correctly
     * @param id
     */
    @Override
    public void delete(Long id) {
        getRepository().delete(id);
    }
}
