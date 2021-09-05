package com.bridgelabz.addressbookspringbootworkshop.controller;


import com.bridgelabz.addressbookspringbootworkshop.dto.AddressBookDTO;
import com.bridgelabz.addressbookspringbootworkshop.dto.ResponseDTO;
import com.bridgelabz.addressbookspringbootworkshop.model.AddressBookData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("AddressBook")
public class AddressBookController {
    /**
     * Api to get All details from AddressBook
     *
     * @return All Contacts
     */
    @GetMapping("/contacts")
    public ResponseEntity<ResponseDTO> getPersonsAddress()
    {
        AddressBookDTO addressBookDTO = new AddressBookDTO("Sanket Tambe", "Nashik",
                "Nashik", "Maharashtra",422008,"8554038336");
        AddressBookData addressBookData = new AddressBookData(1,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Gel Call Success :",addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    /**
     * Api to get single contact with their Id
     * @param contactId
     * @return Single Contact details
     */
    @GetMapping("/contact/{contactId}")
    public ResponseEntity<ResponseDTO> getPersonsAddress(@PathVariable("contactId") int contactId)
    {
        AddressBookDTO addressBookDTO = new AddressBookDTO("Sanket Tambe", "Nashik",
                "Nashik", "Maharashtra",422008,"8554038336");
        AddressBookData addressBookData = new AddressBookData(contactId,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Gel Call Success :",addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    /**
     * Api for creating contact details for Storing into Addressbook
     * @return Success message after storing proper details
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addPersonsAddress(@RequestBody AddressBookDTO addressBookDTO)
    {
        AddressBookData addressBookData = new AddressBookData(2,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Person Data Successfully :",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    /**
     * Api to update contact
     * @return success message after updating details
     */
    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDTO> updatePersonsAddress(@PathVariable("contact") int contactId,
                                                            @RequestBody AddressBookDTO addressBookDTO)
    {
        AddressBookData addressBookData = new AddressBookData(contactId,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Persons Data Updated Successfully :",addressBookData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    /**
     * Api to details to delete contact their ID
     * @param contactId
     * @return Success Message after Deleting contact
     */
    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDTO> deletePersonsAddress(@PathVariable("contactId") int contactId)
    {
        ResponseDTO responseDTO = new ResponseDTO("Data Deleted Successfully", "Deleted Id : "+ contactId);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
