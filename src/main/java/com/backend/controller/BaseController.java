package com.backend.controller;

import com.Model.Register.Band;
import com.Model.type.FormType;
import com.backend.DBAccess.BandDAO;
import com.backend.DBAccess.UserDAO;
import com.Model.Register.User;
import java.lang.String;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BandDAO bandDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView registration(FormType formType) {
        if(formType.getType() == 1)
            return new ModelAndView("user");
        else if(formType.getType() == 2)
            return new ModelAndView("band");
        else if(formType.getType() == 3)
            return new ModelAndView("channel");
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(User user) {
        userDAO.insertUser(user);
        return "index";
    }

    @RequestMapping(value = "addBand", method = RequestMethod.POST)
    public String addBand(Band band) {
        bandDAO.insertBand(band);
        return "index";
    }

   // @RequestMapping(value = "addChannel", method = RequestMethod.POST)

}
