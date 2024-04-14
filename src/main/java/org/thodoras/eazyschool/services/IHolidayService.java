package org.thodoras.eazyschool.services;

import org.thodoras.eazyschool.domain.HolidayDomain;

import java.util.List;

public interface IHolidayService {
    List<HolidayDomain> getHolidays();
}
