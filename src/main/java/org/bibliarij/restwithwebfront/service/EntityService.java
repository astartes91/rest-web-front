package org.bibliarij.restwithwebfront.service;

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
     * Save entity
     * @param entity
     * @return
     */
    Object save(Object entity);

    /**
     * Delete entity by id
     * @param id
     */
    void delete(Long id);
}
