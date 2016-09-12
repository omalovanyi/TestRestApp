package com.mycompany.omalovanyi.ws.rest.web.controller;

import com.mycompany.omalovanyi.ws.rest.model.Contact;
import com.mycompany.omalovanyi.ws.rest.service.ContactService;
import com.mycompany.omalovanyi.ws.rest.web.exception.ContactNotFoundException;
import com.mycompany.omalovanyi.ws.rest.web.exception.RestApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hello")
public class ContactController {

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET, produces = "application/json")
    public List<Contact> showContactList(@RequestParam(value = "nameFilter") String nameFilter) {
        List<Contact> result = null;
        try {
            result = contactService.findContactByNameFilter(nameFilter);

            if (result.isEmpty()) {
                throw new ContactNotFoundException();
            }

        } catch (ContactNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RestApplicationException();
        }

        return result;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such contacts")
    @ExceptionHandler(ContactNotFoundException.class)
    public void contactNotFoundException() {
    }

}
