package org.thodoras.eazyschool.domain;

import lombok.Data;

@Data
public class ContactDomain {

    private String name;
    private String mobileNum;
    private String email;
    private String subject;
    private String message;
}
