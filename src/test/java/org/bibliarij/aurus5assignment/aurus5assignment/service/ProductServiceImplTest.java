package org.bibliarij.aurus5assignment.aurus5assignment.service;

import org.bibliarij.aurus5assignment.aurus5assignment.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDateTime;

/**
 * Tests for class {@link ProductServiceImpl}
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({LocalDateTime.class, ProductServiceImpl.class})
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository repository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void get() {
    }

    @Test
    public void create() {
    }

    @Test
    public void update() {
    }

    @Test
    public void getProductsByCategoryId() {
    }
}