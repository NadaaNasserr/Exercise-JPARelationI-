package com.example.school.Repository;

import com.example.school.Medol.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

    Address findAddressById(Integer id);

    Address findAddressByTeacher_Id(Integer id);
}
