package com.example.school.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {


    @Positive(message = "teacher id must be number")
    @NotNull(message = "teacher id must be not null")
    private Integer teacher_id;


    @Pattern(regexp = "[^0-9]*" , message = "area must not contain numbers")
    @NotEmpty(message = "area must be not null")
    private String area;


    @Pattern(regexp = "[^0-9]*" , message = "street must not contain numbers")
    @NotEmpty(message = "street must be not null")
    private String street;


    @NotNull(message = "building Number must be not null")
    @Positive(message = "building Number must be number")
    private Integer buildingNumber;

}
