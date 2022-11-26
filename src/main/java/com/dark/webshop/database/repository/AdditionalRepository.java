package com.dark.webshop.database.repository;

import com.dark.webshop.database.entity.food.Additional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdditionalRepository extends JpaRepository<Additional, Integer> {
    @Query("select add from Additional add where add.deleted =?1")
    List<Additional> findAllByOrderByNameAsc(boolean deleted);

    @Modifying
    @Query(nativeQuery = true, value = "delete from joinfoodcatalogadditionals where additionalId = ?1")
    void removeFromAvailableAdditionals(Integer id);
}