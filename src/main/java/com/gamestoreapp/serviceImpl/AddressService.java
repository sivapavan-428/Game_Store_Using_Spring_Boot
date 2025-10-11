package com.gamestoreapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamestoreapp.entity.Address;
import com.gamestoreapp.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    // Add a new address
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    // Get single address by ID
    public Address getAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }

    // Get all addresses for a specific user
    public List<Address> getAddressesByUserId(Long userId) {
        return addressRepository.findByUserId(userId);
    }

    // Delete an address
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    // Update an existing address
    public Address updateAddress(Long id, Address updatedAddress) {
        Address address = getAddressById(id);
        address.setName(updatedAddress.getName());
        address.setPhoneNumber(updatedAddress.getPhoneNumber());
        address.setHouseNo(updatedAddress.getHouseNo());
        address.setStreet(updatedAddress.getStreet());
        address.setLandmark(updatedAddress.getLandmark());
        address.setCity(updatedAddress.getCity());
        address.setZipCode(updatedAddress.getZipCode());
        return addressRepository.save(address);
    }
}
