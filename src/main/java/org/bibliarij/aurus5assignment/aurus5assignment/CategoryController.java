package org.bibliarij.aurus5assignment.aurus5assignment;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Spring REST controller for {@link Category} entity
 *
 * @author Vladimir Nizamutdinov
 */
@Api("REST controller for Category entity")
@RequestMapping("/categories")
@RestController
public class CategoryController {

    /**
     * REST endpoint for getting all entities
     * @return
     */
    @ApiOperation("Getting all entities")
    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getEntities(){

        Category category = new Category();
        category.setName("Name");
        category.setDescription("Description");
        return Arrays.asList(category);
    }
}
