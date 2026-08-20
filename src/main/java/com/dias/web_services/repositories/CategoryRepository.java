package com.dias.web_services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dias.web_services.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    

}
