package org.thodoras.eazyschool.repositories.db.models;

import lombok.Data;
import org.thodoras.eazyschool.domain.HolidayDomain;

import java.util.ArrayList;
import java.util.List;

@Data
public class HolidayModel {
    private int id;
    private String day;
    private String reason;
    private String type;

    public HolidayDomain toDomain() {
        var result = new HolidayDomain();
        result.setId(getId());
        result.setDay(getDay());
        result.setReason(getReason());
        result.setType(getType());
        return result;
    }

    public static List<HolidayDomain> toDomains(List<HolidayModel> holidayModels) {
        var results = new ArrayList<HolidayDomain>();
        for (var holidayModel : holidayModels) {
            results.add(holidayModel.toDomain());
        }

        return results;
    }
}
