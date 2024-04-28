package org.thodoras.eazyschool.api.html.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thodoras.eazyschool.api.html.dtos.contact.AddContactRequestDto;
import org.thodoras.eazyschool.domain.ContactDomain;
import org.thodoras.eazyschool.helpers.aspects.interfaces.LogExceptionAspect;
import org.thodoras.eazyschool.interfaces.IContactService;

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

    @LogExceptionAspect
    @GetMapping("/displayMessages")
    public ModelAndView getContact(Model model) {
        var contacts = contactService.getContacts();
        var modelAndView = new ModelAndView("messages.html");
        modelAndView.addObject("contacts", contacts);
        return modelAndView;
    }

    @LogExceptionAspect
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

    @LogExceptionAspect
    @GetMapping("/closeMsg")
    public String closeMsg(@RequestParam int id) {
        contactService.updateStatus(id);
        return "redirect:/displayMessages";
    }
}
