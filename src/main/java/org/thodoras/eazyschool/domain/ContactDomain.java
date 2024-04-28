package org.thodoras.eazyschool.domain;

import lombok.Data;

@Data
public class ContactDomain extends Audit {

    private int id;
    private String name;
    private String mobileNum;
    private String email;
    private String subject;
    private String message;
    private Status status;

    public enum Status {
        OPEN,
        CLOSED
    }
}
