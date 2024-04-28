package org.thodoras.eazyschool.interfaces;

import org.thodoras.eazyschool.domain.ContactDomain;

import java.util.List;

public interface IContactService {
    List<ContactDomain> getContacts();
    ContactDomain addContact(ContactDomain contactDomain);
    int updateStatus(int id);
}
