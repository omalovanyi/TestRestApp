package com.mycompany.omalovanyi.ws.rest.service;

import com.mycompany.omalovanyi.ws.rest.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")

public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    @Autowired
    private ContactService contactService;

    @Test
    public void testFindByNameFilterGetAll() {
        contactService.findContactByNameFilter("all");
        verify(contactRepository, times(1)).getAll();
        verify(contactRepository, times(0)).findByNameFilter(anyString());
    }

    @Test
    public void testFindByNameFilter() {
        contactService.findContactByNameFilter("^.*[ai].*$");
        verify(contactRepository, times(0)).getAll();
        verify(contactRepository, times(1)).findByNameFilter(anyString());
    }

}



