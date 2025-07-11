package com.project.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.capstone.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
