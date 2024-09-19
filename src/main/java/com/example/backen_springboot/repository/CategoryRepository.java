package com.example.backen_springboot.repository;

import com.example.backen_springboot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    @Query("Select c from Category c Where c.name=:name And c.parentCategory.name=:parentCategoryName")
    Category findByNameAndParant(@Param("name") String name,
                                        @Param("parentCategoryName") String parentCategoryName);
}
