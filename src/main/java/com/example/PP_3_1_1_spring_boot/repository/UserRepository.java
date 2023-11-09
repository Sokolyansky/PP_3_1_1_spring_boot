package com.example.PP_3_1_1_spring_boot.repository;

import com.example.PP_3_1_1_spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
