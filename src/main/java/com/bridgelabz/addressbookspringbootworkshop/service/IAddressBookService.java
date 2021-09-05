package com.bridgelabz.addressbookspringbootworkshop.service;

import com.bridgelabz.addressbookspringbootworkshop.dto.AddressBookDTO;
import com.bridgelabz.addressbookspringbootworkshop.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getPersonsAddressData();
    AddressBookData getPersonsAddressDataById(int personId);
    AddressBookData createPersonsAddressData(AddressBookDTO addressBookDTO);
    AddressBookData updatePersonsAddressData(int personId, AddressBookDTO addressBookDTO);
    void deletePersonsAddressData(int personId);
}
