package org.thodoras.eazyschool.dtos.contact;

import lombok.Data;
import org.thodoras.eazyschool.domain.ContactDomain;

@Data
public class AddContactRequestDto {

    private String name;
    private String mobileNum;
    private String email;
    private String subject;
    private String message;

    public ContactDomain toDomain() {
        var result = new ContactDomain();
        result.setName(getName());
        result.setMobileNum(getMobileNum());
        result.setEmail(getEmail());
        result.setSubject(getSubject());
        result.setMessage(getMessage());
        return result;
    }
}
