package com.example.simple_hotel_managment_system.repository;

import com.example.simple_hotel_managment_system.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> getRoomByRoomNumber(int roomNumber);

    List<Room> findByHotelId(Long hotelId);

    void updateRoomById(Long id);
}
