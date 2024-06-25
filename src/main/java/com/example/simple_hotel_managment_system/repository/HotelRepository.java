package com.example.simple_hotel_managment_system.repository;

import com.example.simple_hotel_managment_system.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> getHotelsByCity(String city);
    void updateHotelById(Long id);
}
