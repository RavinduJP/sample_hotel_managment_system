package com.example.simple_hotel_managment_system.service;

import com.example.simple_hotel_managment_system.entity.Hotel;
import com.example.simple_hotel_managment_system.entity.Room;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    List<Hotel> getAllHotels();

    Optional<Hotel> getHotelById(Long id);

    List<Hotel> getHotelsByCity(String city);

    void createHotel(Hotel hotel);

    void UpdateHotel(Long id);

    void deleteHotel(Long hotel);

}
