package org.thodoras.eazyschool.api.html.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception ex) {
        var errPage = new ModelAndView();
        errPage.setViewName("error");
        errPage.addObject("errmsg", ex.getMessage());
        return errPage;
    }
}
