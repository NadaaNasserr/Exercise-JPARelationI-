package com.example.school.Controller;



import com.example.school.DTO.AddressDTO;
import com.example.school.Medol.Address;
import com.example.school.Service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;


    @GetMapping("/get")
    public ResponseEntity getAllAddress(){
        return ResponseEntity.status(200).body(addressService.getAllAddress());
    }


    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body("Address added");


    }


    @PutMapping("update/{id}")
    public ResponseEntity updateAddress(@PathVariable Integer id ,@RequestBody @Valid AddressDTO addressDTO){

        addressService.updateAddress(id,addressDTO);
        return ResponseEntity.status(200).body("Address updated");

    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("Address deleted");

    }
}
