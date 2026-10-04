package com.employeeManagemnet.service;

import com.employeeManagemnet.entity.ContactDetails;
import com.employeeManagemnet.repository.ContactDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactDetailsService {
    @Autowired
    private ContactDetailsRepository contactDetailsRepo;

    public void saveContact(ContactDetails contactDetails) {
        contactDetailsRepo.save(contactDetails);
    }

    public List<ContactDetails> getAllContact() {
        return contactDetailsRepo.findAll();
    }

    public void updateContact(int cid, ContactDetails contactDetails) {
        Optional<ContactDetails> optExistingContact = contactDetailsRepo.findById(cid);
        if (optExistingContact.isPresent()) {
            ContactDetails existingContact = optExistingContact.get();
            existingContact.setPhoneNumber(contactDetails.getPhoneNumber());
            existingContact.setEmailId(contactDetails.getEmailId());
            contactDetailsRepo.save(existingContact);
        }

    }

}
