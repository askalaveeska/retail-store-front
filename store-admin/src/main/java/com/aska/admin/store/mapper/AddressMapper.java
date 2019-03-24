package com.aska.admin.store.mapper;

import com.aska.admin.store.entity.AddressEntity;
import com.aska.admin.store.model.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDTO from(final AddressEntity addressEntity){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressId(addressEntity.getAddressId());
        addressDTO.setAddressLine1(addressEntity.getAddressLine1());
        addressDTO.setAddressLine2(addressEntity.getAddressLine2());
        addressDTO.setAddressLine3(addressEntity.getAddressLine3());
        addressDTO.setCity(addressEntity.getCity());
        addressDTO.setState(addressEntity.getState());
        addressDTO.setCountry(addressEntity.getCountry());
        addressDTO.setPostalCode(addressEntity.getPostalCode());
        return addressDTO;
    }

    public AddressEntity from(final AddressDTO addressDTO){
        AddressEntity addressEntity = new AddressEntity();
        addressDTO.setAddressId(addressDTO.getAddressId());
        addressDTO.setAddressLine1(addressDTO.getAddressLine1());
        addressDTO.setAddressLine2(addressDTO.getAddressLine2());
        addressDTO.setAddressLine3(addressDTO.getAddressLine3());
        addressDTO.setCity(addressDTO.getCity());
        addressDTO.setState(addressDTO.getState());
        addressDTO.setCountry(addressDTO.getCountry());
        addressDTO.setPostalCode(addressDTO.getPostalCode());
        return addressEntity;
    }

}
