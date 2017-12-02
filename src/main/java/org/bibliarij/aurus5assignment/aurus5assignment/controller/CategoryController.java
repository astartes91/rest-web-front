package org.bibliarij.aurus5assignment.aurus5assignment.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bibliarij.aurus5assignment.aurus5assignment.entity.Category;
import org.bibliarij.aurus5assignment.aurus5assignment.service.EntityService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Spring REST controller for {@link Category} entity
 *
 * @author Vladimir Nizamutdinov
 */
@Api("REST controller for Category entity")
@RequestMapping("/categories")
@RestController
public class CategoryController extends EntityController {

    @Resource(name = "categoryServiceImpl")
    private EntityService service;

    /**
     * REST endpoint for creating new entity
     * @param entity
     * @return
     */
    @ApiOperation("Create new entity")
    @RequestMapping(method = RequestMethod.POST)
    public Object create(@RequestBody Category entity){
        return getEntityService().create(entity);
    }

    @Override
    protected EntityService getEntityService() {
        return service;
    }
}
