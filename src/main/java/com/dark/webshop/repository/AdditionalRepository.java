package com.dark.webshop.repository;

import com.dark.webshop.entity.food.Additional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdditionalRepository extends JpaRepository<Additional, Integer> {
        public List<Additional> findAllByOrderByNameAsc();
}