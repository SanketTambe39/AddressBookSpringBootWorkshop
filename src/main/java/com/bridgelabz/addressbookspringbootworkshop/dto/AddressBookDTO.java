package com.bridgelabz.addressbookspringbootworkshop.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    public String fullName;
    public String address;
    public String city;
    public String state;
    public long zipcode;
    public String phoneNumber;
}
