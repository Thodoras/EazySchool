package org.thodoras.eazyschool.api.html.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thodoras.eazyschool.api.html.dtos.contact.AddContactRequestDto;
import org.thodoras.eazyschool.services.IContactService;

@Slf4j
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
    public String addContact(@Valid AddContactRequestDto addContactRequestDto, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("errors", errors.getFieldErrors());
            log.error("Add contact form validation failed due to: " + errors.toString());
            return "contact.html";
        }
        contactService.addContact(addContactRequestDto.toDomain());
        return "redirect:/contact";
    }
}
