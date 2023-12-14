package com.example.hotel.Controller;


import com.example.hotel.Model.Booking;
import com.example.hotel.Model.Customer;
import com.example.hotel.Service.BookingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/get")
    public ResponseEntity getAllBooking() {

        return ResponseEntity.status(200).body(bookingService.getAllBooking());
    }

    @PostMapping("/add")
    public ResponseEntity addBooking(@RequestBody @Valid Booking booking) {


        bookingService.addBooking(booking);
        return ResponseEntity.status(200).body("Book successfully");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBooking(@PathVariable Integer id, @RequestBody @Valid Booking booking) {



        Booking bookingUpdate = bookingService.updateBooking(id, booking);
        return ResponseEntity.status(200).body(bookingUpdate);
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.status(200).body("booking deleted");
    }




    @GetMapping("/bill/{id}")
    public ResponseEntity calculateTotalBill(@PathVariable Integer id) {
     Booking bill = bookingService.calculateTotalBill(id);
        return ResponseEntity.status(200).body(bill);

    }



    @PutMapping("/CheckIn/{id}")
    public ResponseEntity CheckIn(@PathVariable Integer id) {
        bookingService.CheckIn(id);
        return ResponseEntity.status(200).body("enjoy your stay");
    }

    @PutMapping("/CheckOut/{id}")
    public ResponseEntity CheckOut(@PathVariable Integer id) {
        bookingService.CheckOut(id);
        return ResponseEntity.status(200).body("Thank you for your stay");
    }





    @GetMapping("/calculateNight/{id}")
    public ResponseEntity calculateNight(@PathVariable Integer id) {
        Long calculateNight = bookingService.calculateNight(id);
        return ResponseEntity.status(200).body(calculateNight);
    }



    @GetMapping ("/report")
    public ResponseEntity report() {
        return ResponseEntity.status(200).body(bookingService.report());
    }





    @GetMapping ("/findBookingByCheckInDate/{date}")
    public ResponseEntity findBookingByCheckInDate(@PathVariable LocalDate date) {
        List<Booking> bookingList = bookingService.findBookingByCheckInDate(date);
        return ResponseEntity.status(200).body(bookingList);
    }






}
