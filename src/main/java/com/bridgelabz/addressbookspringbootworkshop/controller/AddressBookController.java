package com.bridgelabz.addressbookspringbootworkshop.controller;


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
    public ResponseEntity<String> getPersonsAddress()
    {
        return new ResponseEntity<String>("Get Call Success Inside Contacts : ", HttpStatus.OK);
    }
    /**
     * Api to get single contact with their Id
     * @param contactId
     * @return Single Contact details
     */
    @GetMapping("/contact/{contactId}")
    public ResponseEntity<String> getPersonsAddress(@PathVariable("contactId") int contactId)
    {
        return new ResponseEntity<String>("Get Call Success inside contact with ID i.e: "
                + contactId,HttpStatus.OK);
    }
    /**
     * Api for creating contact details for Storing into Addressbook
     * @return Success message after storing proper details
     */
    @PostMapping("/create")
    public ResponseEntity<String> addPersonsAddress()
    {
        return new ResponseEntity<String>("Created Contact Successfully : ",HttpStatus.OK);
    }
    /**
     * Api to update contact
     * @return success message after updating details
     */
    @PutMapping("/update")
    public ResponseEntity<String> updatePersonsAddress()
    {
        return new ResponseEntity<String>("Updated Contact Successfully :",HttpStatus.OK);
    }

    /**
     * Api to details to delete contact their ID
     * @param contactId
     * @return Success Message after Deleting contact
     */
    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<String> deletePersonsAddress(@PathVariable("contactId") int contactId)
    {
        return new ResponseEntity<String>("Deleted Contact Successfully with Id : "
                + contactId,HttpStatus.OK);
    }
}
