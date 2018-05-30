package lv.javaguru.java2.controller;

import lv.javaguru.java2.services.Error;
import lv.javaguru.java2.services.userlogin.UserLoginRequest;
import lv.javaguru.java2.services.userlogin.UserLoginResponse;
import lv.javaguru.java2.services.userlogin.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public ModelAndView loginGet(ModelAndView model) {
        UserLoginRequest request = new UserLoginRequest();
        model.addObject("userDto", request);
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String registerPost(@ModelAttribute("userDto") UserLoginRequest request,
                               ModelMap model) {
        UserLoginResponse response = userLoginService.login(request);
        if (!response.getErrors().isEmpty()) {
            for (Error error : response.getErrors()) {
                model.addAttribute(error.getField(), error.getErrorMessage());
            }
            return "login";
        } else {
            model.addAttribute("login", response.getLogin());
            return "index";
        }
    }
}
