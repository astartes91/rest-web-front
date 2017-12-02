package org.bibliarij.aurus5assignment.aurus5assignment.controller;

import io.swagger.annotations.Api;
import org.bibliarij.aurus5assignment.aurus5assignment.entity.Category;
import org.bibliarij.aurus5assignment.aurus5assignment.service.EntityService;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @Override
    protected EntityService getEntityService() {
        return service;
    }
}
