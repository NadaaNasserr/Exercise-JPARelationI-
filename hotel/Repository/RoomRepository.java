package com.example.hotel.Repository;


import com.example.hotel.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {


   Room findByRoomId(Integer id);

   List<Room> findAllByOrderByPrice();

   List<Room> findAllByOrderByRating();




//@Query("select r from Room r where r.roomId=?1 and r.rating=?2")
//Room addRating(Integer roomId , Float rating);


@Query("select r.isAvailable from Room r where r.isAvailable=?1")
 Boolean roomAvailableNow(Boolean IsAvailable);



@Query("select room.price from Room room , Booking r where r.bookingId=?1")
Integer getPrice(Integer bookingId);




@Query("select r from Room r where r.isAvailable=true")
List<Room> allRoomsAvailable();


List<Room> findAllByRoomType(String RoomType);



@Query("select r from Room r where r.roomCapacity = ?1")
List<Room>  allRoomByNumberOfPeople(Integer numberOfPeople);




//List<Room> findAllByIsAvailable(Boolean isAvailable);
//List<Room> findAllByIsAvailable();

}
