package org.thodoras.eazyschool.dtos.contact;

import org.thodoras.eazyschool.domain.ContactDomain;

public class AddContactRequestDto {

    private String name;
    private String mobileNum;
    private String email;
    private String subject;
    private String message;

    public String getName() {
        return name;
    }

    public ContactDomain toDomain() {
        return new ContactDomain(
                getName(),
                getMobileNum(),
                getEmail(),
                getSubject(),
                getMessage()
        );
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AddContactDto{" +
                "name='" + name + '\'' +
                ", mobileNum='" + mobileNum + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
