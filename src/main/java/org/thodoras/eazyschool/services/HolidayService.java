package org.thodoras.eazyschool.services;

import org.springframework.stereotype.Service;
import org.thodoras.eazyschool.domain.HolidayDomain;

import java.util.Arrays;
import java.util.List;

@Service
public class HolidayService implements IHolidayService {

    private static final List<HolidayDomain> HOLIDAYS = Arrays.asList(
            new HolidayDomain("Jan 1", "New Year's Day", HolidayDomain.Type.FESTIVAL),
            new HolidayDomain("Oct 31", "Halloween", HolidayDomain.Type.FESTIVAL),
            new HolidayDomain("Jan 17", "Martin Luther King Jr. Day", HolidayDomain.Type.FEDERAL)
    );

    @Override
    public List<HolidayDomain> getHolidays() {
        return HOLIDAYS;
    }
}
