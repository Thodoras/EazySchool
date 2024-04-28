package org.thodoras.eazyschool.domain;

import lombok.Data;

@Data
public class HolidayDomain {

    private int id;
    private String day;
    private String reason;
    private Type type;

    public enum Type {
        GENERIC, FESTIVAL, FEDERAL
    }

    public void setType(String type) {
        if (type.equals(Type.FESTIVAL.toString())) {
            this.type = Type.FESTIVAL;
        } else if (type.equals(Type.FEDERAL.toString())) {
            this.type = Type.FEDERAL;
        } else {
            this.type = Type.GENERIC;
        }
    }

}
