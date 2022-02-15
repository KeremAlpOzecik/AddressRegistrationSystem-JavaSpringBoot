package com.patika.stspringboothw2.controller;

import com.patika.stspringboothw2.dto.AddressDto;
import com.patika.stspringboothw2.entity.*;
import com.patika.stspringboothw2.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AddressController {
    private final CountryService countryService;
    private final ProvinceService provinceService;
    private final TownService townService;
    private final NeighborhoodService neighborhoodService;
    private final StreetService streetService;
    private final AddressService addressService;


    @GetMapping("/country")
    public ResponseEntity findAll(){
        List<Country> countryDtoList=countryService.findAll();
    return new ResponseEntity(countryDtoList,HttpStatus.OK);
    }
    @RequestMapping(value = "/country/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Country> findByNameCountry(@PathVariable String name) {

        return (List<Country>) countryService.findByCode(name);
    }
    @GetMapping("/town")
    public ResponseEntity findAllTown(){
        List<Town> towns=townService.findAll();
        return new ResponseEntity(towns,HttpStatus.OK);
    }

    @PostMapping("/country")
    public void addNewCountry(@RequestBody Country country){
        countryService.addNewCountry(country);
   }

    @PostMapping("/province")
    public void addNewProvince(@RequestBody Province province){
       provinceService.addNewProvince(province);
    }

    @PostMapping("/town")
    public void addNewTown(@RequestBody Town town){
        townService.addNewTown(town);
    }

    @PostMapping("/neighborhood")
    public void addNeighborhood(@RequestBody Neighborhood neighborhood){
        neighborhoodService.addNeighborhood(neighborhood);
    }


    @RequestMapping(value = "/province/{plateCode}", method = RequestMethod.GET)
    @ResponseBody
    public List<Province> findByPlateCode(@PathVariable String plateCode) {

        return (List<Province>) provinceService.findByPlateCode(plateCode);
    }

    @GetMapping("/province")
    public ResponseEntity<List<Province>> findAllProvince(){
        List<Province> countryDtoList=provinceService.findAllProvince();
        return new ResponseEntity<>(countryDtoList,HttpStatus.OK);
    }

    @RequestMapping(value = "/town/{provinceName}", method = RequestMethod.GET)
    @ResponseBody
    public List<Town> findByProvinceName(@PathVariable String provinceName) {

        return (List<Town>) townService.findProvinceTowns(provinceName);
    }
    @GetMapping("/neighborhood")
    public ResponseEntity<List<Neighborhood>> findAllNeigborhood(){
        List<Neighborhood> neighborhoods=neighborhoodService.findAllNeigborhood();
        return new ResponseEntity<>(neighborhoods,HttpStatus.OK);
    }


    @PutMapping(path = "neighborhood/{neighborhoodId}")
    public void updateNeighborhood(@PathVariable("neighborhoodId")Long neighborhoodId,
                              @RequestParam(required = false)String name){
        neighborhoodService.updateNeighborhood(neighborhoodId,name);
    }

    @RequestMapping(value = "/neighborhood/{townName}", method = RequestMethod.GET)
    @ResponseBody
    public List<Neighborhood> findbyTownName(@PathVariable String townName) {

        return (List<Neighborhood>) neighborhoodService.findTownNeighborhoods(townName);
    }

    @PostMapping("/street")
    public void addStreet(@RequestBody Street street){
       streetService.addStreet(street);
    }
    @GetMapping("/street")
    public ResponseEntity<List<Street>> findAllStreet(){
        List<Street> streets=streetService.findAllStreet();
        return new ResponseEntity<>(streets,HttpStatus.OK);
    }


    @PutMapping(path = "street/{streetId}")
    public void updateStreet(@PathVariable("streetId")Long streetId,
                              @RequestParam(required = false)String name){
        streetService.updateStreet(streetId,name);
    }

    @RequestMapping(value = "/street/{neighName}", method = RequestMethod.GET)
    @ResponseBody
    public List<Street> findbyNeighborhoodName(@PathVariable String neighName) {

        return (List<Street>) streetService.findNeighborhoodStreets(neighName);
    }

    // ADRES İÇİN REQUESTLER
    @GetMapping("/address")
    public ResponseEntity findAllAddress(){

        List<AddressDto> addressDtoList = addressService.findAll();

        return ResponseEntity.ok(addressDtoList);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){

        AddressDto addressDto = addressService.findById(id);

        return ResponseEntity.ok(addressDto);
    }

    @PostMapping("/address")
    public ResponseEntity save(@RequestBody AddressDto addressDto){

        addressDto = addressService.save(addressDto);

        return ResponseEntity.ok(addressDto);
    }

    @DeleteMapping("/address/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        addressService.delete(id);

        return ResponseEntity.ok(Void.TYPE);
    }

    @PutMapping("/address")
    public ResponseEntity update(@RequestBody AddressDto addressDto){

        addressDto = addressService.update(addressDto);

        return ResponseEntity.ok(addressDto);
    }
}
