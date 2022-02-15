package com.patika.stspringboothw2.converter;

import com.patika.stspringboothw2.dto.AddressDto;
import com.patika.stspringboothw2.entity.Address;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressConverter {

    public List<AddressDto> convertToAddressDtoList(List<Address> addressList) {

        List<AddressDto> addressDtoList = new ArrayList<>();
        for (Address address : addressList) {

            AddressDto AddressDto = convertToAddressDto(address);

            addressDtoList.add(AddressDto);
        }

        return addressDtoList;
    }





    public AddressDto convertToAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCountry(address.getCountry());
        addressDto.setProvince(address.getProvince());
        addressDto.setTown(address.getTown());
        addressDto.setNeighborhood(address.getNeighborhood());
        addressDto.setStreet(address.getStreet());
        addressDto.setAptNumber(address.getAptNumber());
        addressDto.setDoorNumber(address.getDoorNumber());

        return addressDto;
    }
}
