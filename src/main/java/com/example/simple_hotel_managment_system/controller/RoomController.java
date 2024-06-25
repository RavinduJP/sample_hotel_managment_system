package com.example.simple_hotel_managment_system.controller;

import com.example.simple_hotel_managment_system.entity.Room;
import com.example.simple_hotel_managment_system.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/all")
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "room-list";
    }

    @GetMapping("/{id}")
    public String getRoomById(@PathVariable Long id, Model model) {
        Room room = roomService
                .getRoomById(id).orElseThrow(()-> new IllegalArgumentException("Invalid room number: " + id));
        model.addAttribute("room",room);
        return "room-details";
    }

    @GetMapping("/room-number/{roomNumber}")
    public String getRoomByRoomNumber(@PathVariable int roomNumber, Model model) {
        Room room = roomService.getRoomByRoomNumber(roomNumber)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room number: " + roomNumber));
        model.addAttribute("room", room);
        return "room-details";
    }

    @GetMapping("/new")
    public String showAddRoomForm(Model model) {
        model.addAttribute("room", new Room());
        return "room-form";
    }

    @PostMapping("/add")
    public String addRoom(Room room, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "room-form";
        }
        roomService.createRoom(room);
        redirectAttributes.addFlashAttribute("successMessage", "Room added successfully");
        return "redirect:/room";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Room room = roomService.getRoomById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room id: " + id));
        model.addAttribute("room", room);
        return "room-form";
    }

    @PostMapping("/edit/{id}")
    public String updateRoom(@PathVariable Long id, Room room, BindingResult result,
                             RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "room-form";
        }
        room.setId(id);
        roomService.UpdateRoom(id);
        redirectAttributes.addFlashAttribute("successMessage", "Room updated successfully");
        return "redirect:/rooms";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        roomService.deleteRoom(id);
        redirectAttributes.addFlashAttribute("successMessage", "Room deleted successfully");
        return "redirect:/rooms";
    }
}
