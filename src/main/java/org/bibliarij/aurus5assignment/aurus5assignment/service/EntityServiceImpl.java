package org.bibliarij.aurus5assignment.aurus5assignment.service;

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
     * Save entity
     *
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
     * @param id
     */
    @Override
    public void delete(Long id) {
        getRepository().delete(id);
    }
}
