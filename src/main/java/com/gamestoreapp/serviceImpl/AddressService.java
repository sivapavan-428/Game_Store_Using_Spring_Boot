package com.gamestoreapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gamestoreapp.entity.Address;
import com.gamestoreapp.entity.User;
import com.gamestoreapp.repository.AddressRepository;
import com.gamestoreapp.repository.UserRepository;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Address> getAddressesByUser(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return addressRepository.findByUser(user);
    }

    public Address addAddress(Long userId, Address address) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        address.setUser(user);
        return addressRepository.save(address);
    }

    public Address updateAddress(Long addressId, Address updatedAddress) {
        Address address = addressRepository.findById(addressId)
            .orElseThrow(() -> new RuntimeException("Address not found"));

        address.setName(updatedAddress.getName());
        address.setPhone(updatedAddress.getPhone());
        address.setHouse(updatedAddress.getHouse());
        address.setLandmark(updatedAddress.getLandmark());
        address.setStreet(updatedAddress.getStreet());
        address.setCity(updatedAddress.getCity());
        address.setZip(updatedAddress.getZip());

        return addressRepository.save(address);
    }

    public void deleteAddress(Long addressId) {
        Address address = addressRepository.findById(addressId)
            .orElseThrow(() -> new RuntimeException("Address not found"));
        addressRepository.delete(address);
    }
}

