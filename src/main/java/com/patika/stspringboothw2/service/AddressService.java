package com.patika.stspringboothw2.service;

import com.patika.stspringboothw2.converter.AddressConverter;
import com.patika.stspringboothw2.converter.AddressMapper;
import com.patika.stspringboothw2.dto.AddressDto;
import com.patika.stspringboothw2.entity.Address;
import com.patika.stspringboothw2.service.entityservice.AddressEntitiyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressEntitiyService addressEntitiyService;
    private final AddressConverter addressConverter;

    public List<AddressDto> findAll() {

        List<Address> AddressList = addressEntitiyService.findAll();

        List<AddressDto> addressDtoList = addressConverter.convertToAddressDtoList(AddressList);

        return addressDtoList;
    }


    public AddressDto save(AddressDto addressDto) {

        Address address = AddressMapper.INSTANCE.convertToAddress(addressDto);

        address = addressEntitiyService.save(address);

        addressDto = AddressMapper.INSTANCE.convertToAddressDto(address);

        return addressDto;
    }


    public void delete(Long id) {

        Address address = addressEntitiyService.getByIdWithControl(id);

        addressEntitiyService.delete(address);
    }

    public AddressDto findById(Long id) {

        Address address = addressEntitiyService.getByIdWithControl(id);

        AddressDto addressDto = AddressMapper.INSTANCE.convertToAddressDto(address);

        return addressDto;
    }


    public AddressDto update(AddressDto addressDto) {

        controlIsCustomerExist(addressDto);

        Address address;
        address = AddressMapper.INSTANCE.convertToAddress(addressDto);
        addressEntitiyService.save(address);

       addressDto = AddressMapper.INSTANCE.convertToAddressDto(address);

        return addressDto;
    }

    private void controlIsCustomerExist(AddressDto addressDto) {

        Long id = addressDto.getId();
        boolean isExist = addressEntitiyService.existsById(id);
        if (!isExist){
            throw new IllegalStateException("Address does not exist");
        }
    }
}
