package org.bibliarij.restwithwebfront.repository;

import org.bibliarij.restwithwebfront.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data repository for {@link Product} entity
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Delete products with specfied category id
     * @param categoryId
     */
    @Modifying
    @Query("DELETE FROM Product p WHERE p.category.id = :categoryId")
    void deleteByCategoryId(@Param("categoryId") Long categoryId);

    /**
     * Get products by specified category id
     * @param categoryId
     * @return
     */
    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> getByCategoryId(@Param("categoryId") Long categoryId);
}
