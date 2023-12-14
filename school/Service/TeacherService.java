package com.example.school.Service;


import com.example.school.API.ApiException;
import com.example.school.Medol.Address;
import com.example.school.Medol.Teacher;
import com.example.school.Repository.AddressRepository;
import com.example.school.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;



    public List<Teacher> getALLTeacher(){

        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){

        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id , Teacher teacher){

        Teacher teacher1 = teacherRepository.findTeacherById(id);

        if(teacher1 == null){
            throw new ApiException("id not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setSalary(teacher.getSalary());
        teacher1.setEmail(teacher.getEmail());

        teacherRepository.save(teacher1);

    }
    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);

        if(teacher == null){
            throw new ApiException("id not found");
        }
        teacherRepository.delete(teacher);
    }


    public Address getTeacherAddress(Integer id){
       Address address = addressRepository.findAddressByTeacher_Id(id);

       if(address == null){
           throw new ApiException("id not found");

       }
       return address;

    }
}
