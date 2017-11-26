package org.bibliarij.aurus5assignment.aurus5assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Service for {@link Category} entity
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
@Service
public class CategoryServiceImpl extends EntityServiceImpl {

    @Autowired
    private CategoryRepository repository;

    @Override
    protected JpaRepository getRepository() {
        return repository;
    }
}
