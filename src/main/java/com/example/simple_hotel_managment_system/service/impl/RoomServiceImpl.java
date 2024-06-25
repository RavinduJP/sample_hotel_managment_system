package com.example.simple_hotel_managment_system.service.impl;

import com.example.simple_hotel_managment_system.entity.Room;
import com.example.simple_hotel_managment_system.repository.RoomRepository;
import com.example.simple_hotel_managment_system.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;


    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public Optional<Room> getRoomByRoomNumber(int roomNumber) {
        return  roomRepository.getRoomByRoomNumber(roomNumber);
    }

    @Override
    public List<Room> getRoomsByHotelId(long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

    @Override
    public void createRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void UpdateRoom(Long id) {
        roomRepository.updateRoomById(id);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
