package com.patika.stspringboothw2;

import com.patika.stspringboothw2.entity.Address;
import com.patika.stspringboothw2.entity.Country;
import com.patika.stspringboothw2.entity.Street;
import com.patika.stspringboothw2.repository.AddressRepository;
import com.patika.stspringboothw2.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
@RequiredArgsConstructor
@SpringBootApplication
public class StSpringbootHw2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StSpringbootHw2Application.class, args);
	}

	private final AddressRepository addressRepository;

	@Override
	public void run(String... args) throws Exception {
		Address address=new Address(3L,"Türkiye","İzmir","Bornova","Ergene","520.sk","20","11");
		Address address2=new Address(2L,"Türkiye","Kocaeli","Derince","Yenikent","120.sk","21","12");
		this.addressRepository.save(address);
		this.addressRepository.save(address2);



	}
}
