package vttp2022.ssf.ssfworkshop14b.controller;

import java.security.Provider.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vttp2022.ssf.ssfworkshop14b.model.Contact;
import vttp2022.ssf.ssfworkshop14b.service.ContactsRedis;


@Controller
public class AddressbookController {
    private static final Logger logger = LoggerFactory.getLogger(AddressbookController.class);

    @Autowired
    ContactsRedis service;

    @GetMapping("/")
    public String contactForm(Model model){
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @GetMapping("/contact/{contactId}")
    public String showContact(Model model, @PathVariable(value="contactId") String contactId){
        Contact contact = service.findById(contactId);
        model.addAttribute("contact", contact);
        return "showContact";
    }

    @PostMapping("/contact")
    public String saveContact(@ModelAttribute Contact contact, Model model){
        Contact c = new Contact(contact.getName(), contact.getEmail(), contact.getTelephone());
        service.save(c);
        model.addAttribute("contact", c);
        return "showContact";
    }
}
