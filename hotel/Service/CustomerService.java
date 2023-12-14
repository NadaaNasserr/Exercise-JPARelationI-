package com.example.hotel.Service;


import com.example.hotel.API.ApiException;
import com.example.hotel.Model.Booking;
import com.example.hotel.Model.Customer;
import com.example.hotel.Model.Room;
import com.example.hotel.Repository.BookingRepository;
import com.example.hotel.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepository customerRepository;
    private final BookingRepository bookingRepository;
   // private final BookingService bookingService;

    public List<Customer> getAllCustomer(){

        return customerRepository.findAll();
    }


    public void addCustomer(Customer customer) {


        customerRepository.save(customer);
    }

    public Customer updateCustomer(Integer id, Customer customer) {

        Customer customer1 = customerRepository.findByCustomerId(id);

        if(customer1 == null){
            throw new ApiException("customer id not found");
        }



        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setPhoneNumber(customer.getPhoneNumber());
        customer1.setNumberOfPeople(customer.getNumberOfPeople());
        customerRepository.save(customer1);
        return customer1;

    }


    public void deleteCustomer(Integer id){
        Customer customer = customerRepository.findByCustomerId(id);
        if(customer == null){
            throw new ApiException("Customer id not found");
        }
        customerRepository.delete(customer);
    }






    public List<Booking> getAllCustomerBookings(Integer customerId){
        List<Booking> bookingList = bookingRepository.getAllBookingCustomer(customerId);
        if(bookingList.isEmpty()){
            throw new ApiException("customer ID incorrect");
        }
        return  bookingList;
    }

    public Integer countOfCustomerBooking(Integer customerId){
        Integer countOfCustomerBooking = bookingRepository.getAllBookingCustomer(customerId).size();
        if( bookingRepository.getAllBookingCustomer(customerId).isEmpty()){
            throw new ApiException("customerId incorrect");

        }
        return countOfCustomerBooking;
    }





}
