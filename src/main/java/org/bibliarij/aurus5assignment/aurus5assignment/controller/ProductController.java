package org.bibliarij.aurus5assignment.aurus5assignment.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bibliarij.aurus5assignment.aurus5assignment.entity.Product;
import org.bibliarij.aurus5assignment.aurus5assignment.service.EntityService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Spring REST controller for {@link Product} entity
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
@Api("REST controller for Product entity")
@RequestMapping("/products")
@RestController
public class ProductController extends EntityController {

    @Resource(name = "productServiceImpl")
    private EntityService service;

    /**
     * REST endpoint for creating new entity
     * @param entity
     * @return
     */
    @ApiOperation("Create new entity")
    @RequestMapping(method = RequestMethod.POST)
    public Object create(@RequestBody Product entity){
        return getEntityService().create(entity);
    }

    @Override
    protected EntityService getEntityService() {
        return service;
    }
}
