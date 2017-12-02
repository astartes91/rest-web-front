package org.bibliarij.aurus5assignment.aurus5assignment.controller;

import io.swagger.annotations.ApiOperation;
import org.bibliarij.aurus5assignment.aurus5assignment.service.EntityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Generic entity controller
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
public abstract class EntityController {

    /**
     * REST endpoint for getting all entities
     * @return
     */
    @ApiOperation("Getting all entities")
    @RequestMapping(method = RequestMethod.GET)
    public List getEntities(){

        return getEntityService().findAll();
    }

    protected abstract EntityService getEntityService();
}
