package uz.ruslan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: murad
 * Date: 9/27/17 11:21 PM
 */
@Controller
public class MainPageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage(HttpServletResponse response, HttpServletRequest request) {
        return new ModelAndView("index");
    }

}
