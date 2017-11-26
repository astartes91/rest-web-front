package org.bibliarij.aurus5assignment.aurus5assignment;

import io.swagger.annotations.ApiOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    @ApiOperation("Getting all entities")
    @RequestMapping(method = RequestMethod.GET)
    public List getEntities(){

        return getRepository().findAll();
    }

    protected abstract JpaRepository getRepository();
}
