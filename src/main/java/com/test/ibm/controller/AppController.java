package com.test.ibm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class that is the controller for the initial load of the application
 */
@Controller
public class AppController {

    /**
     * Method that redirects index
     * @return
     */
    @RequestMapping("/")
    public String app() {
        return "index";
    }
}
