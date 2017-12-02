package org.bibliarij.aurus5assignment.aurus5assignment.service;

import java.util.List;

/**
 * Generic entity service
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
public interface EntityService {

    /**
     * Find all entities
     * @return
     */
    List findAll();

    /**
     * Create new entity
     * @param entity
     * @return
     */
    Object create(Object entity);

    /**
     * Delete entity by od
     * @param id
     */
    void delete(Long id);
}
