package org.bibliarij.aurus5assignment.aurus5assignment;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Category entity class
 *
 * @author Vladimir Nizamutdinov
 */
@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;
}
