package com.mycompany.omalovanyi.ws.rest.service;

import com.mycompany.omalovanyi.ws.rest.model.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> findContactByNameFilter(String nameFilter);

}
