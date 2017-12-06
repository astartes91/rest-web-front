package org.bibliarij.aurus5assignment.aurus5assignment.service;

import org.bibliarij.aurus5assignment.aurus5assignment.entity.Category;
import org.bibliarij.aurus5assignment.aurus5assignment.repository.CategoryRepository;
import org.bibliarij.aurus5assignment.aurus5assignment.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Tests for class {@link CategoryServiceImpl}
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl service;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ProductRepository productRepository;

    /**
     * @verifies behave correctly
     * @see CategoryServiceImpl#update(Category)
     */
    @Test
    public void update_shouldBehaveCorrectly() {
        Category entity = new Category();
        entity.setId(1L);
        service.update(entity);
        Mockito.verify(categoryRepository).save(entity);
    }

    /**
     * @verifies behave correctly
     * @see CategoryServiceImpl#delete(Long)
     */
    @Test
    public void delete_shouldBehaveCorrectly() {

        service.delete(1L);
        Mockito.verify(productRepository).deleteByCategoryId(1L);
        Mockito.verify(categoryRepository).delete(1L);
    }
}