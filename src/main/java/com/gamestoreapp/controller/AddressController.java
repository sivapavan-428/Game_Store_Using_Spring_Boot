package com.gamestoreapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gamestoreapp.entity.Address;
import com.gamestoreapp.serviceImpl.AddressService;
import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/user/{userId}")
    public List<Address> getAddresses(@PathVariable Long userId) {
        return addressService.getAddressesByUser(userId);
    }

    @PostMapping("/add/{userId}")
    public Address addAddress(@PathVariable Long userId, @RequestBody Address address) {
        return addressService.addAddress(userId, address);
    }

    @PutMapping("/update/{addressId}")
    public Address updateAddress(@PathVariable Long addressId, @RequestBody Address address) {
        return addressService.updateAddress(addressId, address);
    }

    @DeleteMapping("/delete/{addressId}")
    public void deleteAddress(@PathVariable Long addressId) {
        addressService.deleteAddress(addressId);
    }
}
