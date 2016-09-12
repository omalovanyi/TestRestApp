package com.mycompany.omalovanyi.ws.rest.service.impl;

import com.mycompany.omalovanyi.ws.rest.model.Contact;
import com.mycompany.omalovanyi.ws.rest.repository.ContactRepository;
import com.mycompany.omalovanyi.ws.rest.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public List<Contact> findContactByNameFilter(String nameFilter) {

        if ("all".equals(nameFilter)) {
            return contactRepository.getAll();
        } else {
            return contactRepository.findByNameFilter(nameFilter);
        }
    }
}
