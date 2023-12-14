package com.example.hotel.Repository;


import com.example.hotel.Model.Booking;
import com.example.hotel.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {


    Booking findByBookingId(Integer id);

    Booking findByRoomId(Integer roomId);


    @Query("select b.checkInDate from Booking b where b.bookingId=?1")
    LocalDate getCheckInDate(Integer id );


    @Query("select b.checkOutDate from Booking b where b.bookingId=?1")
    LocalDate getCheckOutDate(Integer id);


//    @Query("select price from Room r, Booking b where b.bookingId=?1 ")
//    Integer getPrice(Integer bookingId);





@Query("select b from Booking b where b.roomId=?1 and b.checkInDate=?2")
Booking check(Integer roomId , LocalDate date);






List<Booking> findBookingByCheckInDate(LocalDate date);



@Query("select b from Booking b where b.customerId=?1")
List<Booking> getAllBookingCustomer(Integer customerId);




@Query("select b from Booking b where b.roomId=?1")
List<Booking> getAllBookingRoom(Integer roomID);




//@Query("select count from Room r where r.roomId=?1")
//Integer getCount(Integer roomID);

//    @Query("select b from Booking b where b.")
//    LocalDate bweedate(Integer id);


Booking findByCustomerId(Integer customerId);



@Query("select b from Booking b where b.customerId=?1 and b.bookingId=?2")
Booking getByBookingIdAndCustomerId(Integer customerId, Integer bookingId);


Integer find



}
