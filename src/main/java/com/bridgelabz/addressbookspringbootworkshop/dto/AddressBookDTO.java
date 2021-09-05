package com.bridgelabz.addressbookspringbootworkshop.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    public String fullName;
    public String address;
    public String city;
    public String state;
    public long zipcode;
    public String phoneNumber;

    @Override
    public String toString() {
        return "AddressBookDTO{" +
            "fullName='" + fullName + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", zipcode=" + zipcode +
            ", phoneNumber=" + phoneNumber +
            '}';
        }
}
