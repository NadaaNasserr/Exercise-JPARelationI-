package com.example.school.Medol;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "teacher name must not be empty")
    @Pattern(regexp = "[^0-9]*" , message = "name must not contain numbers")
    private String name;



    @Column(columnDefinition = "int not null")
    @Positive(message = "age must be number")
    @NotNull(message = "age must not be null")
    private Integer age;



    @Column(columnDefinition = "varchar(20) not null unique")
    @NotEmpty(message = "email must not be empty")
    @Email(message = "Must be a valid email format")
    private String email;



    @Column(columnDefinition = "double not null")
    @Positive(message = "building Number must be number")
    @NotNull(message = "salary must not be null")
    private double salary;




    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;



}
