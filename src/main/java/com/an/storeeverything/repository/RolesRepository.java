package com.an.storeeverything.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.an.storeeverything.models.RolesEntity;

public interface RolesRepository extends JpaRepository<RolesEntity, Long> {
    RolesEntity findByName(String name);
}
