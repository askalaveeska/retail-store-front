package com.aska.admin.store.mapper;

import com.aska.store.entity.AddressEntity;
import com.aska.store.model.AddressDTO;
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

}
