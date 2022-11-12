package com.dark.webshop.repository;

import com.dark.webshop.database.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}