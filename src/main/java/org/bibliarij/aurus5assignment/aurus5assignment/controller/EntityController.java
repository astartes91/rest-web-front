package org.bibliarij.aurus5assignment.aurus5assignment.controller;

import io.swagger.annotations.ApiOperation;
import org.bibliarij.aurus5assignment.aurus5assignment.service.EntityService;
import org.springframework.web.bind.annotation.PathVariable;
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

        return getEntityService().getAll();
    }

    /**
     * REST endpoint for getting entity by id
     * @return
     */
    @ApiOperation("Getting entity by id")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Object getEntitiy(@PathVariable Long id){

        return getEntityService().get(id);
    }

    /**
     * REST endpoint for deleting entity
     */
    @ApiOperation("Delete entity")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Long id){
        getEntityService().delete(id);
    }

    protected abstract EntityService getEntityService();
}
