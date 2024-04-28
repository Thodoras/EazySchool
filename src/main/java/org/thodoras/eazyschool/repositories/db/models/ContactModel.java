package org.thodoras.eazyschool.repositories.db.models;

import lombok.Data;
import org.thodoras.eazyschool.domain.Audit;
import org.thodoras.eazyschool.domain.ContactDomain;

import java.util.ArrayList;
import java.util.List;

@Data
public class ContactModel extends Audit {

    private int id;
    private String name;
    private String mobileNum;
    private String email;
    private String subject;
    private String message;
    private ContactDomain.Status status;

    public ContactModel() {}

    public ContactModel(ContactDomain contactDomain) {
        setId(contactDomain.getId());
        setName(contactDomain.getName());
        setMobileNum(contactDomain.getMobileNum());
        setEmail(contactDomain.getEmail());
        setSubject(contactDomain.getSubject());
        setMessage(contactDomain.getMessage());
        setStatus(contactDomain.getStatus());
        if (contactDomain.getCreatedAt() != null) {
            setCreatedAt(contactDomain.getCreatedAt());
        }

        if (contactDomain.getUpdatedAt() != null) {
            setUpdatedAt(contactDomain.getUpdatedAt());
        }
    }

    public ContactDomain toDomain() {
        var result = new ContactDomain();
        result.setId(getId());
        result.setName(getName());
        result.setMobileNum(getMobileNum());
        result.setEmail(getEmail());
        result.setSubject(getSubject());
        result.setMessage(getMessage());
        result.setCreatedAt(getCreatedAt());
        result.setUpdatedAt(getUpdatedAt());
        return result;
    }

    public static List<ContactDomain> toDomains(List<ContactModel> contacts) {
        var results = new ArrayList<ContactDomain>();
        for (var contact : contacts) {
            results.add(contact.toDomain());
        }

        return results;
    }
}
