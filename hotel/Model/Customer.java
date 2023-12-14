package com.example.hotel.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Customer {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "name must be not empty")
    private String name;


    @Email(message = "email must be valid")
    @Column(columnDefinition = "varchar(20) not null unique")
    @NotEmpty(message = "email must be not empty")
    private String email;


    @Pattern(regexp ="^05\\d{8}$" , message = "Must start with \"05\" and consists of exactly 10 digits")
    @Column(columnDefinition = "varchar(10) not null unique")
    @NotEmpty(message = "phone Number must be not empty")
    private String phoneNumber;


    @Positive(message = "number Of People must be numeric")
    @NotNull(message = "number Of People must be not empty")
    private Integer numberOfPeople;









}
