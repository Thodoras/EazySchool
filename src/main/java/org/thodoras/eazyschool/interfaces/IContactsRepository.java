package org.thodoras.eazyschool.interfaces;

import org.thodoras.eazyschool.domain.ContactDomain;

import java.util.List;

public interface IContactsRepository {

    List<ContactDomain> getcontacts(String status);
    ContactDomain addContact(ContactDomain contactDomain);
    int updateStatus(int id, ContactDomain.Status status);
}
