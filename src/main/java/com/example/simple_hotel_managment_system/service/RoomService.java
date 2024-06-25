package com.example.simple_hotel_managment_system.service;

import com.example.simple_hotel_managment_system.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<Room> getAllRooms();

    Optional<Room> getRoomById(Long id);

    Optional<Room> getRoomByRoomNumber(int roomNumber);

    List<Room> getRoomsByHotelId(long hotelId);

    void createRoom(Room room);

    void UpdateRoom(Long id);

    void deleteRoom(Long id);

}
