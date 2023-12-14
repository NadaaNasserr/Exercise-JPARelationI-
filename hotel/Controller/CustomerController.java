package com.example.hotel.Controller;


import com.example.hotel.Model.Booking;
import com.example.hotel.Model.Customer;
import com.example.hotel.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/get")
    public ResponseEntity getAllCustomer() {

        return ResponseEntity.status(200).body(customerService.getAllCustomer());
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody @Valid Customer customer, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer added");

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @RequestBody @Valid Customer customer, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        Customer customerUpdate = customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body(customerUpdate);
    }





    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {

        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Customer deleted");
    }

    @GetMapping ("/getAllBookingCustomer/{customerId}")
    public ResponseEntity getAllBookingCustomer(@PathVariable Integer customerId) {
        List<Booking> bookingList = customerService.getAllCustomerBookings(customerId);
        return ResponseEntity.status(200).body(bookingList);
    }


    @GetMapping ("/countOfCustomerBooking/{customerId}")
    public ResponseEntity countOfCustomerBooking(@PathVariable Integer customerId) {
        Integer x = customerService.countOfCustomerBooking(customerId);
        return ResponseEntity.status(200).body("count Of Customer Booking" + x);
    }





}
