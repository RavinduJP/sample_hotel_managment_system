package com.example.simple_hotel_managment_system.repository;

import com.example.simple_hotel_managment_system.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {


}
