package org.thodoras.eazyschool.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thodoras.eazyschool.domain.ContactDomain;

@Slf4j
@Service
public class ContactService implements IContactService {

    @Override
    public boolean addContact(ContactDomain contactDomain) {
        log.info(contactDomain.toString());
        return true;
    }
}
