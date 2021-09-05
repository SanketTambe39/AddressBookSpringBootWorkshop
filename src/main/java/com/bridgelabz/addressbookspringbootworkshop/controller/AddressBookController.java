package com.bridgelabz.addressbookspringbootworkshop.controller;


import com.bridgelabz.addressbookspringbootworkshop.dto.AddressBookDTO;
import com.bridgelabz.addressbookspringbootworkshop.dto.ResponseDTO;
import com.bridgelabz.addressbookspringbootworkshop.model.AddressBookData;
import com.bridgelabz.addressbookspringbootworkshop.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("AddressBook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;
    /**
     * Api to get All details from AddressBook
     *
     * @return All Contacts
     */
    @GetMapping("/contacts")
    public ResponseEntity<ResponseDTO> getPersonsAddress()
    {
        List<AddressBookData> addressList = addressBookService.getPersonsAddressData();
        ResponseDTO responseDTO =  new ResponseDTO("Get Call Success : ", addressList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Api to get single contact with their Id
     * @param contactId
     * @return Single Contact details
     */
    @GetMapping("/contact/{contactId}")
    public ResponseEntity<ResponseDTO> getPersonsAddress(@PathVariable("contactId") int contactId)
    {
        AddressBookData addressBookData = addressBookService.getPersonsAddressDataById(contactId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful : ", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    /**
     * Api for creating contact details for Storing into Addressbook
     * @return Success message after storing proper details
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addPersonsAddress(@Valid @RequestBody AddressBookDTO addressBookDTO)
    {
        AddressBookData addressBookData = addressBookService.createPersonsAddressData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created AddressBook Data Successfully :",
                addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    /**
     * Api to update contact
     * @return success message after updating details
     */
    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updatePersonsAddress(@PathVariable("contactId") int contactId,
                                                            @Valid @RequestBody AddressBookDTO addressBookDTO)
    {
        AddressBookData addressBookData = addressBookService.updatePersonsAddressData(contactId, addressBookDTO);
        ResponseDTO responseDTO =  new ResponseDTO("AddressBook Data Updated Successfully: ",
                addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Api to details to delete contact their ID
     * @param contactId
     * @return Success Message after Deleting contact
     */
    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deletePersonsAddress(@PathVariable("contactId") int contactId)
    {
        addressBookService.deletePersonsAddressData(contactId);
        ResponseDTO responseDTO = new ResponseDTO("Data Deleted Successfully", "Deleted Id : "+ contactId);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}