package com.example.inventoryservice.repositories;

import com.example.inventoryservice.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface creatorRepository extends JpaRepository<Creator,Long> {
}
