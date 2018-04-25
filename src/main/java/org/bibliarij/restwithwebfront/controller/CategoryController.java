package org.bibliarij.restwithwebfront.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bibliarij.restwithwebfront.entity.Category;
import org.bibliarij.restwithwebfront.service.CategoryService;
import org.bibliarij.restwithwebfront.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    private CategoryService service;

    /**
     * REST endpoint for creating new entity
     * @param entity
     * @return
     */
    @ApiOperation("Create new entity")
    @RequestMapping(method = RequestMethod.POST)
    public Object create(@RequestBody Category entity){
        return getEntityService().save(entity);
    }

    /**
     * REST endpoint for updating existing entity
     * @param entity
     * @return
     */
    @ApiOperation("Update existing entity")
    @RequestMapping(method = RequestMethod.PUT)
    public Object update(@RequestBody Category entity){

        return service.update(entity);
    }

    @Override
    protected EntityService getEntityService() {
        return service;
    }
}
