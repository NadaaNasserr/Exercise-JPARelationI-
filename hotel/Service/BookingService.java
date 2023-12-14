package com.example.hotel.Service;


import com.example.hotel.API.ApiException;
import com.example.hotel.Model.Booking;
import com.example.hotel.Model.Customer;
import com.example.hotel.Model.Room;
import com.example.hotel.Repository.BookingRepository;
import com.example.hotel.Repository.CustomerRepository;
import com.example.hotel.Repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {


    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;
    private final RoomService roomService;
    private final CustomerService customerService;


    public List<Booking> getAllBooking() {

        return bookingRepository.findAll();
    }


    public void addBooking(Booking booking) {

        Room room = roomRepository.findByRoomId(booking.getRoomId());
        Customer customer = customerRepository.findByCustomerId(booking.getCustomerId());
        // LocalDate localDate = bookingRepository.

        if (customer == null) {
            throw new ApiException("customer ID incorrect");

        }
        if (room == null) {
            throw new ApiException("room ID is incorrect");

        }

        Boolean isAvailable = roomRepository.roomAvailableNow(room.getIsAvailable());

        if (!isAvailable) {
            throw new ApiException("room is not available now");
        } else
            bookingRepository.save(booking);


    }


    public Booking updateBooking(Integer id, Booking booking) {
        Booking booking1 = bookingRepository.findByBookingId(id);
        Room room = roomRepository.findByRoomId(booking.getRoomId());
        Customer customer = customerRepository.findByCustomerId(booking.getCustomerId());

        if (booking1 == null) {
            throw new ApiException("Booking ID is incorrect");
        }
        if (customer == null) {
            throw new ApiException("customer ID is incorrect");

        }
        if (room == null) {
            throw new ApiException("room ID is incorrect");

        }


        booking1.setRoomId(booking.getRoomId());
        booking1.setCustomerId(booking.getCustomerId());
        booking1.setCheckInDate(booking.getCheckInDate());
        booking1.setCheckOutDate(booking.getCheckOutDate());
        booking1.setTotalPrice(booking.getTotalPrice());
        bookingRepository.save(booking1);
        return booking1;

    }


    public void deleteBooking(Integer id) {
        Booking booking = bookingRepository.findByBookingId(id);
        if (booking == null) {
            throw new ApiException("booking ID is incorrect");
        }
        bookingRepository.delete(booking);

    }


    public void CheckIn(Integer id) {
        Booking booking = bookingRepository.findByBookingId(id);
        if (booking == null) {
            throw new ApiException("booking ID is incorrect");
        }
        Room room = roomRepository.findByRoomId(booking.getRoomId());
        room.setIsAvailable(false);
        roomRepository.save(room);
    }


    public void CheckOut(Integer id) {
        Booking booking = bookingRepository.findByBookingId(id);
        if (booking == null) {
            throw new ApiException("booking ID is incorrect");
        }

        Room room = roomRepository.findByRoomId(booking.getRoomId());
        room.setIsAvailable(true);
        roomRepository.save(room);

    }




    public Long calculateNight(Integer bookingId) {
        Booking booking = bookingRepository.findByBookingId(bookingId);
        LocalDate checkInDate = bookingRepository.getCheckInDate(bookingId);
        LocalDate checkOutDate = bookingRepository.getCheckOutDate(bookingId);
        if (booking == null) {
            throw new ApiException("booking ID is incorrect");
        }
        Long calculateNight = ChronoUnit.DAYS.between((checkInDate), (checkOutDate));
        return calculateNight;
    }




        public Booking calculateTotalBill(Integer bookingId) {
        Booking booking = bookingRepository.findByBookingId(bookingId);

        Integer priceRoom = roomRepository.getPrice(bookingId);

        if (booking == null) {
            throw new ApiException("booking ID is incorrect");
        }
        Integer totalPrice = Math.toIntExact(priceRoom * calculateNight(bookingId));
        booking.setTotalPrice(totalPrice);
        bookingRepository.save(booking);
        return booking;
 }




    public String report() {
        Integer customer = customerService.getAllCustomer().size();
        Integer room = roomService.getAllRoom().size();
        Integer booking = getAllBooking().size();
        return "Information about the hotel" + '\n' + "number of customers: " + customer + '\n'
                + "number of rooms: " + room + '\n' + "number of reservations: " + booking;
    }




















        public List<Booking> findBookingByCheckInDate(LocalDate date){
            List<Booking> bookingList = bookingRepository.findBookingByCheckInDate(date);
        if(bookingList.isEmpty()){
            throw new ApiException("By CheckInDate incorrect");
        }
        return  bookingList;
        }


    }



