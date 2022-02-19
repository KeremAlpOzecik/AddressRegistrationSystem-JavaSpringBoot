package com.patika.stspringboothw2;

import com.patika.stspringboothw2.entity.*;
import com.patika.stspringboothw2.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Provider;
import java.util.List;
@RequiredArgsConstructor
@SpringBootApplication
public class StSpringbootHw2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StSpringbootHw2Application.class, args);
	}

	private final AddressRepository addressRepository;
	private final CountryRepository countryRepository;
	private final ProvinceRepository provinceRepository;
	private final TownRepository townRepository;
	private final NeighborhoodRepository neighborhoodRepository;
	private final StreetRepository streetRepository;

	@Override
	public void run(String... args) throws Exception {
		Address address=new Address(3L,"Türkiye","İzmir","Bornova","Ergene","520.sk","20","11");
		Address address2=new Address(2L,"Türkiye","Kocaeli","Derince","Yenikent","120.sk","21","12");
		this.addressRepository.save(address);
		this.addressRepository.save(address2);

		Country country=new Country(1L,"Fransa","FR");
		Province province=new Province(1L,"Paris","16",country.getId(),country);
		Town town = new Town(1L,"Merkez", province.getId(), province);
		Neighborhood neighborhood=new Neighborhood(1L,"paris mahallesi",town.getId(),town);
		Street street=new Street(1L,"144.sk","7","13",neighborhood.getId(),neighborhood);
		countryRepository.save(country);
		provinceRepository.save(province);
		townRepository.save(town);
		neighborhoodRepository.save(neighborhood);
		streetRepository.save(street);




	}
}
