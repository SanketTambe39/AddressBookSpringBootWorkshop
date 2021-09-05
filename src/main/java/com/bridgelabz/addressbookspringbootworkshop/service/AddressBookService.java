package com.bridgelabz.addressbookspringbootworkshop.service;

import com.bridgelabz.addressbookspringbootworkshop.dto.AddressBookDTO;
import com.bridgelabz.addressbookspringbootworkshop.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AddressBookService implements IAddressBookService{
    /**
     *  Method to get all details from addressbook
     * @return List of all record inside AddressBook
     */
    @Override
    public List<AddressBookData> getPersonsAddressData() {
        List<AddressBookData> addressBookDataList = new ArrayList<>();
        addressBookDataList.add(new AddressBookData(1,new AddressBookDTO("Sanket Tambe",
                "Nashik", "Nashik", "Maharashtra",422008,"8554038336")));
        return addressBookDataList;
    }

    /**
     * Method to get a single record from Id
     * @param personId
     * @return single record
     */
    @Override
    public AddressBookData getPersonsAddressDataById(int personId) {
        AddressBookData addressBookData = new AddressBookData(personId, new AddressBookDTO("Sanket Tambe",
                "Nashik", "Nashik", "Maharashtra",422008,"8554038336"));
        return  addressBookData;
    }

    /**
     * Method to make new contact and store it into database
     * @param addressBookDTO - this will hold all data 
     * @return records stored message if successfull
     */
    @Override
    public AddressBookData createPersonsAddressData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(40,addressBookDTO);
        return addressBookData;
    }

    /**
     * Method to update record with Id
     * @param personId - to check it is present or not
     * @param addressBookDTO - updated information stored here
     * @return updated record information
     */
    @Override
    public AddressBookData updatePersonsAddressData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(personId,addressBookDTO);
        return addressBookData;
    }

    /**
     * method to delete record
     * @param personId - to check that the record with id is present or not
     */
    @Override
    public void deletePersonsAddressData(int personId) {

    }
}
