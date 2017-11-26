package org.bibliarij.aurus5assignment.aurus5assignment;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring REST controller for {@link Product} entity
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
@Api("REST controller for Product entity")
@RequestMapping("/products")
@RestController
public class ProductController extends EntityController {

    @Autowired
    private ProductRepository repository;

    @Override
    protected JpaRepository getRepository() {
        return repository;
    }
}
