package org.thodoras.eazyschool.interfaces;

import org.thodoras.eazyschool.domain.HolidayDomain;

import java.util.List;

public interface IHolidayRepository {
    List<HolidayDomain> list();
}
