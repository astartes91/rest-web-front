package org.bibliarij.restwithwebfront.service;

import org.assertj.core.api.Assertions;
import org.bibliarij.restwithwebfront.entity.Category;
import org.bibliarij.restwithwebfront.entity.Product;
import org.bibliarij.restwithwebfront.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Tests for class {@link ProductServiceImpl}
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Date.class, ProductServiceImpl.class})
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private CategoryService categoryService;

    @Mock
    private ProductRepository repository;

    private Product product;
    private Category category;
    private List<Product> products;
    private Date now;

    @Before
    public void setUp() throws Exception {
        category = new Category();
        product = new Product();
        product.setId(1L);
        product.setCategory(category);
        products = Arrays.asList(product);
        now = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss").parse("2017-06-19T03:58:00");

        Mockito.when(repository.findAll()).thenReturn(products);
        Mockito.when(repository.findOne(1L)).thenReturn(product);
        Mockito.when(categoryService.unproxy(category)).thenReturn(category);
        Mockito.when(repository.getByCategoryId(1L)).thenReturn(products);
        PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(now);
    }

    /**
     * @verifies return correct result
     * @see ProductServiceImpl#getAll()
     */
    @Test
    public void getAll_shouldReturnCorrectResult() {

        List result = productService.getAll();
        Assertions.assertThat(result).isEqualTo(products);
        Mockito.verify(categoryService).unproxy(category);
    }

    /**
     * @verifies return correct result
     * @see ProductServiceImpl#get(Long)
     */
    @Test
    public void get_shouldReturnCorrectResult() {

        Object result = productService.get(1L);
        Assertions.assertThat(result).isEqualTo(product);
        Mockito.verify(categoryService).unproxy(category);
    }

    /**
     * @verifies return correct result
     * @see ProductServiceImpl#create(Product)
     */
    @Test
    public void create_shouldReturnCorrectResult() {

        productService.create(product);
        Assertions.assertThat(product.getAdditionDate()).isEqualTo(now);
        Mockito.verify(repository).save(product);
    }

    /**
     * @verifies return correct result
     * @see ProductServiceImpl#update(Product)
     */
    @Test
    public void update_shouldReturnCorrectResult() {

        Product entityFromDb = new Product();
        entityFromDb.setAdditionDate(now);
        Mockito.when(repository.findOne(1L)).thenReturn(entityFromDb);

        productService.update(product);
        Assertions.assertThat(product.getAdditionDate()).isEqualTo(now);
        Mockito.verify(repository).save(product);
    }

    /**
     * @verifies return correct result
     * @see ProductServiceImpl#getProductsByCategoryId(Long)
     */
    @Test
    public void getProductsByCategoryId_shouldReturnCorrectResult() {
        List<Product> result = productService.getProductsByCategoryId(1L);
        Assertions.assertThat(result).isEqualTo(products);
        Mockito.verify(categoryService).unproxy(category);
    }
}