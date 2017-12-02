package org.bibliarij.aurus5assignment.aurus5assignment.entity;

import lombok.Data;

import javax.persistence.*;

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
}
