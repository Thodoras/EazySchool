package org.thodoras.eazyschool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thodoras.eazyschool.domain.HolidayDomain;
import org.thodoras.eazyschool.helpers.aspects.interfaces.LogAspect;
import org.thodoras.eazyschool.helpers.aspects.interfaces.LogExceptionAspect;
import org.thodoras.eazyschool.interfaces.IHolidayRepository;
import org.thodoras.eazyschool.interfaces.IHolidayService;

import java.util.Arrays;
import java.util.List;

@Service
public class HolidayService implements IHolidayService {

    private final IHolidayRepository holidayRepository;

    @Autowired
    public HolidayService(IHolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @LogAspect @LogExceptionAspect
    @Override
    public List<HolidayDomain> getHolidays() {
        return holidayRepository.list();
    }
}
