package org.bibliarij.aurus5assignment.aurus5assignment.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Tests for class {@link EntityServiceImpl}
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
@RunWith(MockitoJUnitRunner.class)
public class EntityServiceImplTest {

    private static class EntityServiceImplementation extends EntityServiceImpl {

        private JpaRepository repository;

        private EntityServiceImplementation(JpaRepository repository) {
            this.repository = repository;
        }

        @Override
        protected JpaRepository getRepository() {
            return repository;
        }
    }

    @Mock
    private JpaRepository repository;

    private EntityServiceImplementation service;

    @Before
    public void setUp() {
        service = new EntityServiceImplementation(repository);
    }

    /**
     * @verifies behave correctly
     * @see EntityServiceImpl#getAll()
     */
    @Test
    public void getAll_shouldBehaveCorrectly() {

        service.getAll();
        Mockito.verify(repository).findAll();
    }

    /**
     * @verifies behave correctly
     * @see EntityServiceImpl#get(Long)
     */
    @Test
    public void get_shouldBehaveCorrectly() {
        service.get(1L);
        Mockito.verify(repository).findOne(1L);
    }

    /**
     * @verifies behave correctly
     * @see EntityServiceImpl#save(Object)
     */
    @Test
    public void save_shouldBehaveCorrectly() {
        Object entity = new Object();
        service.save(entity);
        Mockito.verify(repository).save(entity);
    }

    /**
     * @verifies behave correctly
     * @see EntityServiceImpl#delete(Long)
     */
    @Test
    public void delete_shouldBehaveCorrectly() {
        service.delete(1L);
        Mockito.verify(repository).delete(1L);
    }
}