package com.example.hotel.Repository;


import com.example.hotel.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    Customer findByCustomerId(Integer id);


}
