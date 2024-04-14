package org.thodoras.eazyschool.domain;

import lombok.Data;

@Data
public class HolidayDomain {

    private final String day;
    private final String reason;
    private final Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }

}
