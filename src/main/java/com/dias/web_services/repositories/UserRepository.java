package com.dias.web_services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dias.web_services.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    

}
