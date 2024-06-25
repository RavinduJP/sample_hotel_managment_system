package com.example.simple_hotel_managment_system.service.impl;

import com.example.simple_hotel_managment_system.entity.Hotel;
import com.example.simple_hotel_managment_system.repository.HotelRepository;
import com.example.simple_hotel_managment_system.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    @Override
    public List<Hotel> getHotelsByCity(String city) {
        return hotelRepository.getHotelsByCity(city);
    }

    @Override
    public void createHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void UpdateHotel(Long id) {
        hotelRepository.updateHotelById(id);
    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
