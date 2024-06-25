package com.example.simple_hotel_managment_system.repository;

import com.example.simple_hotel_managment_system.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
