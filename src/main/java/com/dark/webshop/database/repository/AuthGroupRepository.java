package com.dark.webshop.database.repository;

import com.dark.webshop.database.entity.user.AuthenGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthGroupRepository extends JpaRepository<AuthenGroup, Long> {
    List<AuthenGroup> findByUsername(String username);
}