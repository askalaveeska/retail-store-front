package com.aska.store.controller;

import com.aska.store.entity.AddressEntity;
import com.aska.store.mapper.AddressMapper;
import com.aska.store.model.AddressDTO;
import com.aska.store.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by ppalpandi on 3/9/2019.
 */
@RestController
public class AddressController {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("api/address/{addressId}")
    public ResponseEntity getAddress(@PathVariable("addressId") final long addressId){
        final Optional<AddressEntity> addressEntity = addressRepository.findById(addressId);
        if (addressEntity.isPresent()){
            return ResponseEntity.ok(addressMapper.from(addressEntity.get()));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("api/address")
    public ResponseEntity addAddress(@RequestBody final AddressDTO addressDTO){
        final AddressEntity addressEntity = addressMapper.from(addressDTO);
        addressRepository.save(addressEntity);
        return ResponseEntity.accepted().build();
    }
    @PutMapping("api/address")
    public ResponseEntity updateAddress(@RequestBody final AddressDTO addressDTO){
        final AddressEntity addressEntity = addressMapper.from(addressDTO);
        addressRepository.save(addressEntity);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("api/address/{addressId}")
    public ResponseEntity deleteAddress(@PathVariable("addressId") final long addressId){
        addressRepository.deleteById(addressId);
        return ResponseEntity.ok().build();
    }

}
