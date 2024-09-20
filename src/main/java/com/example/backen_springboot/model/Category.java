package com.example.backen_springboot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max=50)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    // 1 -> parent: null
    // 2 -> parent: 1
    private int level;
}
