package org.thodoras.eazyschool.api.html.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thodoras.eazyschool.domain.HolidayDomain;
import org.thodoras.eazyschool.helpers.aspects.interfaces.LogExceptionAspect;
import org.thodoras.eazyschool.interfaces.IHolidayService;

import java.util.stream.Collectors;

@Controller
public class HolidayController {

    private final IHolidayService holidayService;

    @Autowired
    public HolidayController(IHolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @LogExceptionAspect
    @GetMapping("/holidays")
    public String holidayDisplayPage(
            Model model,
            @RequestParam(required = false) boolean festival,
            @RequestParam(required = false) boolean federal
    ) {
        model.addAttribute("festival", festival);
        model.addAttribute("federal", federal);
        var holidays = holidayService.getHolidays();
        var types = HolidayDomain.Type.values();
        // TODO: Refactor
        for (var type : types) {
            model.addAttribute(type.toString(), (holidays.stream().filter(x -> x.getType().equals(type)).
                    collect(Collectors.toList())));
        }

        return "holidays.html";
    }
}
