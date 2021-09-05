package com.bridgelabz.addressbookspringbootworkshop.service;

import com.bridgelabz.addressbookspringbootworkshop.dto.AddressBookDTO;
import com.bridgelabz.addressbookspringbootworkshop.exceptions.AddressBookException;
import com.bridgelabz.addressbookspringbootworkshop.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AddressBookService implements IAddressBookService{
    private List<AddressBookData> addressBookDataList = new ArrayList<>();
    /**
     *  Method to get all details from addressbook
     * @return List of all record inside AddressBook
     */
    @Override
    public List<AddressBookData> getPersonsAddressData() {
        return addressBookDataList;
    }

    /**
     * Method to get a single record from Id
     * @param personId
     * @return single record
     */
    @Override
    public AddressBookData getPersonsAddressDataById(int personId) {
        return addressBookDataList.stream()
                .filter(addressBookData -> addressBookData.getPersonId() == personId)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Requested Persons Data For An Given Id Is Not Found."));
    }

    /**
     * Method to make new contact and store it into database
     * @param addressBookDTO - this will hold all data 
     * @return records stored message if successfull
     */
    @Override
    public AddressBookData createPersonsAddressData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDataList.size()+1,addressBookDTO);
        addressBookDataList.add(addressBookData);
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
        AddressBookData addressBookData = this.getPersonsAddressDataById(personId);
        addressBookData.setFullName(addressBookDTO.fullName);
        addressBookData.setAddress(addressBookDTO.address);
        addressBookData.setCity(addressBookDTO.city);
        addressBookData.setState(addressBookDTO.state);
        addressBookData.setZipcode(addressBookDTO.zipcode);
        addressBookData.setPhoneNumber(addressBookDTO.phoneNumber);
        addressBookDataList.set(personId-1,addressBookData);
        return addressBookData;
    }

    /**
     * method to delete record
     * @param personId - to check that the record with id is present or not
     */
    @Override
    public void deletePersonsAddressData(int personId) {
        addressBookDataList.remove(personId-1);
    }
}
