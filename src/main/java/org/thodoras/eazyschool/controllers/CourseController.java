package org.thodoras.eazyschool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    @GetMapping(value={"/courses"})
    public String displayCoursesPage() {
        return "courses.html";
    }
}
