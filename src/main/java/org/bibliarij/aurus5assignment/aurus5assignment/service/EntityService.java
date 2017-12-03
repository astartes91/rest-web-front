package org.bibliarij.aurus5assignment.aurus5assignment.service;

import java.util.List;

/**
 * Generic entity service
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
public interface EntityService {

    /**
     * Get all entities
     * @return
     */
    List getAll();

    /**
     * Get entity by id
     * @param id
     * @return
     */
    Object get(Long id);

    /**
     * Create new entity
     * @param entity
     * @return
     */
    Object create(Object entity);

    /**
     * Update existing entity
     * @param entity
     * @return
     */
    Object update(Object entity);

    /**
     * Delete entity by od
     * @param id
     */
    void delete(Long id);
}
