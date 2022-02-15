package com.patika.stspringboothw2.service.entityservice;

import com.patika.stspringboothw2.dto.AddressDto;
import com.patika.stspringboothw2.entity.Address;
import com.patika.stspringboothw2.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressEntitiyService {
    private final AddressRepository addressRepository;

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Optional<Address> findById(Long id){
        return addressRepository.findById(id);
    }

    public Address save(Address address){
        return addressRepository.save(address);
    }

    public void delete(Address address){
        addressRepository.delete(address);
    }

    public Address getByIdWithControl(Long id) {

        Optional<Address> addressOptional = findById(id);

        Address address;
        if (addressOptional.isPresent()){
            address = addressOptional.get();
        } else {
            throw new IllegalStateException("Item not found");
        }

        return address;
    }

    public boolean existsById(Long id){
        return addressRepository.existsById(id);
    }

}
