package com.desciplineGrasser.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {

    @GetMapping("/calendar")
    public String showCalendar() {
        return "calendar"; // this refers to calendar.html in the templates folder
    }
}
