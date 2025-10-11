package com.gamestoreapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gamestoreapp.entity.Address;
import com.gamestoreapp.serviceImpl.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/all/{userId}")
    public List<Address> getUserAddresses(@PathVariable Long userId){
        return addressService.getAddressesByUserId(userId);
    }

    @PostMapping("/add")
    public Address addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return "Address deleted";
    }

    @PutMapping("/update/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address updatedAddress) {
        return addressService.updateAddress(id, updatedAddress);
    }
}
