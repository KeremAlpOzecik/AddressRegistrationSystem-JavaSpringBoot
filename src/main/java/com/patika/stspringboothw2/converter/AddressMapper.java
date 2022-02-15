package com.patika.stspringboothw2.converter;
import com.patika.stspringboothw2.dto.AddressDto;
import com.patika.stspringboothw2.entity.Address;
import org.mapstruct.Mapper;

import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address convertToAddress(AddressDto addressDto);

    List<AddressDto> convertToAddressDtoList(List<Address> addressList);

    AddressDto convertToAddressDto(Address address);
}
