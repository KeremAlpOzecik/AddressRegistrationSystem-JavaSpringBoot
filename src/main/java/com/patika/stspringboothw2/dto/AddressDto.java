package com.patika.stspringboothw2.dto;

import lombok.Data;
@Data
public class AddressDto {
    private Long id;
    private String country;
    private String province;
    private String town;
    private String neighborhood;
    private String street;
    private String doorNumber;
    private String aptNumber;
}
