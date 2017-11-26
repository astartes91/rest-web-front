package org.bibliarij.aurus5assignment.aurus5assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for {@link Category} entity
 *
 * @author Vladimir Nizamutdinov (astartes91@gmail.com)
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
