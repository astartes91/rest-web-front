package org.bibliarij.aurus5assignment.aurus5assignment;

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
}
