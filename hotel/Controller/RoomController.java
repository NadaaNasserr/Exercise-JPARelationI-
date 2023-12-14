package com.example.hotel.Controller;


import com.example.hotel.Model.Booking;
import com.example.hotel.Model.Room;
import com.example.hotel.Service.RoomService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/room")
public class RoomController {

    private final RoomService roomService;




    @GetMapping("/get")
    public ResponseEntity getAllRoom() {

        return ResponseEntity.status(200).body(roomService.getAllRoom());
    }


    @PostMapping("/add")
    public ResponseEntity addRoom(@RequestBody @Valid Room room, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        roomService.addRoom(room);
        return ResponseEntity.status(200).body("Room added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateRoom(@PathVariable Integer id, @RequestBody @Valid Room room, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        Room roomUpdate = roomService.updateRoom(id, room);
        return ResponseEntity.status(200).body(roomUpdate);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRoom(@PathVariable Integer id) {

        roomService.deleteRoom(id);
        return ResponseEntity.status(200).body("Room deleted");
    }


    @GetMapping("/getRoomByPrice")
    public ResponseEntity getRoomByPrice(){

        List<Room> roomList = roomService.findAllByOrderByPrice();
        return ResponseEntity.status(200).body(roomList);
    }

    @GetMapping("/getRoomByRating")
    public ResponseEntity getRoomByRating(){

        List<Room> roomList = roomService.findAllByOrderByRating();
        return ResponseEntity.status(200).body(roomList);
    }


//    @PutMapping("/addRating/{roomId}/{rating}")
//    public ResponseEntity addRating(@PathVariable Integer roomId , @PathVariable Float rating ){
//        return ResponseEntity.status(200).body(roomService.addRating(roomId,rating));
//
//    }


    @GetMapping("/roomAvailableNow/{id}")
    public ResponseEntity roomAvailableNow(@PathVariable Integer id){
        String roomList = roomService.roomAvailableNow(id);
        return ResponseEntity.status(200).body(roomList);
    }




    @GetMapping("/allRoomsAvailable")
    public ResponseEntity allRoomsAvailable(){
        List<Room> roomList = roomService.allRoomsAvailable();
        return ResponseEntity.status(200).body(roomList);
    }



    @GetMapping("/getAllRoomType/{RoomType}")
    public ResponseEntity getAllRoomType(@PathVariable String RoomType){
        List<Room> roomList = roomService.getAllRoomType(RoomType);
        return ResponseEntity.status(200).body(roomList);
    }


    @GetMapping("/allRoomByNumberOfPeople/{numberOfPeople}")
    public ResponseEntity getAllRoomByNumberOfPeople(@PathVariable Integer numberOfPeople){
        List<Room> roomList = roomService.allRoomByNumberOfPeople(numberOfPeople);
        return ResponseEntity.status(200).body(roomList);
    }


    @GetMapping ("/getAllRoomBookings/{roomId}")
    public ResponseEntity getAllRoomBookings(@PathVariable Integer roomId) {
        List<Booking> bookingList = roomService.getAllRoomBookings(roomId);
        return ResponseEntity.status(200).body(bookingList);
    }



    @GetMapping ("/countOfRoomBooking/{roomId}")
    public ResponseEntity countOfRoomBooking(@PathVariable Integer roomId) {
        Integer x = roomService.countOfRoomBooking(roomId);
        return ResponseEntity.status(200).body("count Of Room Booking " + x);
    }

}
