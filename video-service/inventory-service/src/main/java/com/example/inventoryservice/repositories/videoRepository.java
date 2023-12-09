package com.example.inventoryservice.repositories;

import com.example.inventoryservice.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface videoRepository extends JpaRepository<Video,Long> {

}
