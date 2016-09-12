package com.mycompany.omalovanyi.ws.rest.repository;

import com.mycompany.omalovanyi.ws.rest.model.Contact;

import java.util.List;

public interface ContactRepository {

    public List<Contact> findByNameFilter(String nameFilter);

    public List<Contact> getAll();
}
