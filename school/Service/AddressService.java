package com.example.school.Service;


import com.example.school.API.ApiException;
import com.example.school.DTO.AddressDTO;
import com.example.school.Medol.Address;
import com.example.school.Medol.Teacher;
import com.example.school.Repository.AddressRepository;
import com.example.school.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddress() {

        return addressRepository.findAll();

    }

    public void addAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("teacher id not found");
        }
        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);
        addressRepository.save(address);

    }

    public void updateAddress(Integer id, AddressDTO addressDTO) {
        Address address = addressRepository.findAddressById(id);
        if (address == null) {
            throw new ApiException("teacher id not found");

        }

        address.setArea(addressDTO.getArea());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        address.setStreet(addressDTO.getStreet());
        addressRepository.save(address);


    }

    public void deleteAddress(Integer id) {
        Address address = addressRepository.findAddressById(id);
        if (address == null) {
            throw new ApiException("address id not found");
        }

        Teacher teacher = teacherRepository.findTeacherById(id);
        teacher.setAddress(null);
        addressRepository.delete(address);
    }
}
