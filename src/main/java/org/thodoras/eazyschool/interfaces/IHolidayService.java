package org.thodoras.eazyschool.interfaces;

import org.thodoras.eazyschool.domain.HolidayDomain;

import java.util.List;

public interface IHolidayService {
    List<HolidayDomain> getHolidays();
}
