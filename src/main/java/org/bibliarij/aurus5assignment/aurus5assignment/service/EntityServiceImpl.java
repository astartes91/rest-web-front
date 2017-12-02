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
     * Find all entities
     *
     * @return
     */
    @Override
    public List findAll() {
        return getRepository().findAll();
    }

    /**
     * Create new entity
     *
     * @param entity
     * @return
     */
    @Override
    public Object create(Object entity) {
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
