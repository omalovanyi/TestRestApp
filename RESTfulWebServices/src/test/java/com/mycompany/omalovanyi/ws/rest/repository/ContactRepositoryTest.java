package com.mycompany.omalovanyi.ws.rest.repository;

import com.mycompany.omalovanyi.ws.rest.model.Contact;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testFindByNameFilter() {
        List<Contact> contacts = new ArrayList<>();
        List<Contact> result = null;
        Contact contact = null;
        contact = new Contact(2, "Helen");
        contacts.add(contact);
        contact = new Contact(5, "Henry");
        contacts.add(contact);

        result = contactRepository.findByNameFilter("^.*[ai].*$");
        Assert.assertTrue(result.size() == 2);
        Assert.assertTrue(result.equals(contacts));

    }

    @Test
    public void testGetAll() {
        List<Contact> contacts = new ArrayList<>();
        List<Contact> result = null;
        Contact contact = null;
        contact = new Contact(2, "Helen");
        contacts.add(contact);
        contact = new Contact(3, "Linda");
        contacts.add(contact);
        contact = new Contact(4, "Rafael");
        contacts.add(contact);
        contact = new Contact(5, "Henry");
        contacts.add(contact);
        contact = new Contact(6, "Sharon");
        contacts.add(contact);

        result = contactRepository.getAll();
        Assert.assertTrue(result.size() == 5);
        Assert.assertTrue(result.equals(contacts));
    }
}
