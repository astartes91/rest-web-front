package org.bibliarij.aurus5assignment.aurus5assignment.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bibliarij.aurus5assignment.aurus5assignment.entity.Product;
import org.bibliarij.aurus5assignment.aurus5assignment.service.EntityService;
import org.bibliarij.aurus5assignment.aurus5assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private ProductService service;

    @ApiOperation("Get products by category id")
    @RequestMapping(method = RequestMethod.GET, value = "/category/{id}")
    public List<Product> getProducts(@PathVariable(value = "id") Long categoryId){
        return service.getProductsByCategoryId(categoryId);
    }

    /**
     * REST endpoint for creating new entity
     * @param entity
     * @return
     */
    @ApiOperation("Create new entity")
    @RequestMapping(method = RequestMethod.POST)
    public Object create(@RequestBody Product entity){
        return service.create(entity);
    }

    /**
     * REST endpoint for updating existing entity
     * @param entity
     * @return
     */
    @ApiOperation("Update existing entity")
    @RequestMapping(method = RequestMethod.PUT)
    public Object update(@RequestBody Product entity){

        return service.update(entity);
    }

    @Override
    protected EntityService getEntityService() {
        return service;
    }
}
