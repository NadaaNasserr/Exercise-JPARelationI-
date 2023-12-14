package com.example.hotel.Service;


import com.example.hotel.API.ApiException;
import com.example.hotel.Model.Booking;
import com.example.hotel.Model.Customer;
import com.example.hotel.Model.Room;
import com.example.hotel.Repository.BookingRepository;
import com.example.hotel.Repository.CustomerRepository;
import com.example.hotel.Repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;
    private final BookingRepository bookingRepository;
//    private final


    public List<Room> getAllRoom() {

        return roomRepository.findAll();
    }


    public void addRoom(Room room) {


        roomRepository.save(room);
    }

    public Room updateRoom(Integer id, Room room) {

        Room room1 = roomRepository.findByRoomId(id);

        if (room1 == null) {
            throw new ApiException("room ID is incorrect");
        }


        room1.setRoomCode(room.getRoomCode());
        room1.setRoomType(room.getRoomType());
        room1.setFloor(room.getFloor());
        room1.setPrice(room.getPrice());
        room1.setIsAvailable(room.getIsAvailable());
        room1.setRating(room.getRating());
        room1.setRoomCapacity(room.getRoomCapacity());

        roomRepository.save(room1);
        return room1;

    }


    public void deleteRoom(Integer id) {
        Room room = roomRepository.findByRoomId(id);
        if (room == null) {
            throw new ApiException("room ID is incorrect");
        }
        roomRepository.delete(room);

    }


    public List<Room> findAllByOrderByPrice() {
        List<Room> roomList = roomRepository.findAllByOrderByPrice();
        return roomList;
    }


    public List<Room> findAllByOrderByRating() {
        List<Room> roomList = roomRepository.findAllByOrderByRating();
        return roomList;
    }


//    public Room addRating(Integer roomId, Float rating) {

//    List<Float> ratings = new ArrayList<>();
//
//        if (rating < 1 || rating > 5) {
//            throw new ApiException("Rating must be between 1 and 5");
//        }
//
//        Room room1 = roomRepository.findByRoomId(roomId);
//
//        if (room1 == null) {
//            throw new ApiException("room ID is incorrect");
//        }
//
//        ratings.add(rating);
//
//        Float totalRating = (float) 0;
//        totalRating = totalRating + rating;
//        Float AverageRating = (totalRating /count(rating));
//
//
//        room1.setRating(AverageRating);
//        roomRepository.save(room1);
//
//        return room1;
//
//    }

//    public Room addRating(Integer roomId, Float rating) {
//
//
//
//    //    List<Float> ratings = new ArrayList<>();
//
//        if (rating < 1 || rating > 5) {
//            throw new ApiException("Rating must be between 1 and 5");
//        }
//
//        Room room1 = roomRepository.findByRoomId(roomId);
//
//        if (room1 == null) {
//            throw new ApiException("room ID is incorrect");
//        }
//
//    //    ratings.add(rating);
//
//        Float totalRating = room1.getRating() + rating;
//        Float AverageRating = (totalRating /count(rating));
//
//
//        room1.setRating(AverageRating);
//        roomRepository.save(room1);
//
//        return room1;
//
//    }


//    public Integer count(Float rating){
//        List<Float> ratings = new ArrayList<>();
//        ratings.add(rating);
//        Integer count = ratings.size();
//
//        return count++;
//
//    }


    public String roomAvailableNow(Integer id) {
        Room room1 = roomRepository.findByRoomId(id);
        if (room1 == null) {
            throw new ApiException("room ID is incorrect");
        }
        Boolean isAvailable = roomRepository.roomAvailableNow(room1.getIsAvailable());
        if (isAvailable) {
            return "yes is room available now";
        }
        throw new ApiException("room is not available now");
    }


    public List<Room> allRoomsAvailable() {
        List<Room> roomList = roomRepository.allRoomsAvailable();
        if (roomList.isEmpty()) {
            throw new ApiException("are not rooms available");

        }
        return roomList;
    }


    public List<Room> getAllRoomType(String roomType) {
        List<Room> roomList = roomRepository.findAllByRoomType(roomType);
        if (roomList.isEmpty()) {
            throw new ApiException("Room type not available");
        }
        return roomList;
    }

    public List<Room> allRoomByNumberOfPeople(Integer numberOfPeople) {
        List<Room> roomList = roomRepository.allRoomByNumberOfPeople(numberOfPeople);
        if (roomList.isEmpty()) {
            throw new ApiException("no rooms available for the number of people");
        }
        return roomList;
    }


    public List<Booking> getAllRoomBookings(Integer roomID) {

        List<Booking> bookingList = bookingRepository.getAllBookingRoom(roomID);

        if (bookingList.isEmpty()) {
            throw new ApiException("room ID incorrect");

        }
        return bookingList;
    }


    public Integer countOfRoomBooking(Integer roomId) {
        Integer x = bookingRepository.getAllBookingRoom(roomId).size();
        if (bookingRepository.getAllBookingRoom(roomId).isEmpty()) {
            throw new ApiException("room ID incorrect");
        }
        return x;
    }
}









//
//    public List<Room> allRoomsAvailable() {
//
//        List<Room> roomList = roomRepository.findAllByIsAvailable();
//
//
//        for (int i = 0; i < getAllRoom().size(); i++) {
//            if (getAllRoom().get(i).getIsAvailable().equals(true)) {
//                roomList.add(getAllRoom().get(i));
//
//            }
//
//
//        }
//        return roomList;
//       // throw new ApiException("Room id not foundrrr");
//    }
//}


//    public double getAverageRating() {
//        int a=0;
//        for(int i = 0; i < reviews.size() ; i++) {
//            a+=reviews.get(i).getRating();
//        }
//        double sum= a/reviews.size();
//        return sum;
//    }




