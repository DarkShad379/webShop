package com.dark.webshop.repository;

import com.dark.webshop.entity.food.Additional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdditionalRepository extends JpaRepository<Additional, Integer> {
    @Query("select add from Additional add where add.deleted =?1")
    public List<Additional> findAllByOrderByNameAsc(boolean deleted);
}