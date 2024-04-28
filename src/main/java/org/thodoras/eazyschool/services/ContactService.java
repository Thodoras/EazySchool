package org.thodoras.eazyschool.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thodoras.eazyschool.domain.ContactDomain;
import org.thodoras.eazyschool.helpers.aspects.interfaces.LogAspect;
import org.thodoras.eazyschool.helpers.aspects.interfaces.LogExceptionAspect;
import org.thodoras.eazyschool.interfaces.IContactService;
import org.thodoras.eazyschool.interfaces.IContactsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactService implements IContactService {

    private final IContactsRepository contactsRepository;

    @Autowired
    public ContactService(IContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @LogAspect @LogExceptionAspect
    @Override
    public List<ContactDomain> getContacts() {
        return contactsRepository.getcontacts(ContactDomain.Status.OPEN.toString());
    }

    @LogAspect @LogExceptionAspect
    @Override
    public ContactDomain addContact(ContactDomain contactDomain) {
        contactDomain.setStatus(ContactDomain.Status.OPEN);
        contactDomain.setCreatedAt(LocalDateTime.now());
        contactDomain.setUpdatedAt(LocalDateTime.now());
        var result = contactsRepository.addContact(contactDomain);
        return result;
    }

    @LogAspect @LogExceptionAspect
    @Override
    public int updateStatus(int id) {
        return contactsRepository.updateStatus(id, ContactDomain.Status.CLOSED);
    }
}
