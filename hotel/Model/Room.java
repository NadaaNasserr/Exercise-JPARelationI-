package com.example.hotel.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;


    @Column(columnDefinition = "varchar(10) not null unique")
    @NotEmpty(message = "room code must be not empty")
    private String roomCode;


    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "room type must be not empty")
    private String roomType;


    @Positive(message ="room Capacity must be numeric")
    @Column(columnDefinition = "int not null")
    @NotNull(message = "room capacity must be not empty")
    private Integer roomCapacity;

    @Positive(message = "floor must be numeric")
     @Column(columnDefinition = "int not null")
    @NotNull(message = "floor must be not empty")
    private Integer floor;


    @Positive(message ="price must be numeric")
    @Column(columnDefinition = "int not null")
    @NotNull(message = "price must be not empty")
    private Float price;


    @AssertTrue(message = "must be true")
    private Boolean isAvailable;


    @Positive(message = "rating must be numeric")
    @Column(columnDefinition = "double not null")
    private double rating;










}
