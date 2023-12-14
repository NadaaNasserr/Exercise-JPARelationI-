package com.example.school.Repository;


import com.example.school.Medol.Address;
import com.example.school.Medol.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    Teacher findTeacherById(Integer id);

    
}
