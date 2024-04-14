package org.thodoras.eazyschool.api.html.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thodoras.eazyschool.api.html.dtos.contact.AddContactRequestDto;
import org.thodoras.eazyschool.services.IContactService;

@Controller
public class ContactController {
    private final IContactService contactService;

    @Autowired
    public ContactController(IContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String displayContactPage() {
        return "contact.html";
    }

    @PostMapping("/contact")
    public ModelAndView addContact(AddContactRequestDto addContactRequestDto) {
        contactService.addContact(addContactRequestDto.toDomain());
        return new ModelAndView("redirect:/contact");
    }
}
