package org.bibliarij.aurus5assignment.aurus5assignment;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring REST controller for {@link Category} entity
 *
 * @author Vladimir Nizamutdinov
 */
@Api("REST controller for Category entity")
@RequestMapping("/categories")
@RestController
public class CategoryController extends EntityController {

    @Autowired
    private CategoryRepository repository;

    @Override
    protected JpaRepository getRepository() {
        return repository;
    }
}
