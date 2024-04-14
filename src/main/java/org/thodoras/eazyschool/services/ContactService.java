package org.thodoras.eazyschool.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thodoras.eazyschool.controllers.ContactController;
import org.thodoras.eazyschool.domain.ContactDomain;

@Service
public class ContactService implements IContactService {

    private static Logger log = LoggerFactory.getLogger(ContactController.class);

    @Override
    public boolean addContact(ContactDomain contactDomain) {
        log.info(contactDomain.toString());
        return true;
    }
}
