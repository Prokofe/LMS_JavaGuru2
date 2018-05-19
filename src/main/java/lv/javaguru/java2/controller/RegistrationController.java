package lv.javaguru.java2.controller;

import lv.javaguru.java2.services.Error;
import lv.javaguru.java2.services.userregistration.UserRegistrationRequest;
import lv.javaguru.java2.services.userregistration.UserRegistrationResponse;
import lv.javaguru.java2.services.userregistration.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserRegistrationService registrationService;

    @RequestMapping(value = "/registration", method = {RequestMethod.GET})
    public ModelAndView registerGet(ModelAndView model) {
        UserRegistrationRequest request = new UserRegistrationRequest();
        model.addObject("userDto", request);
        model.setViewName("registration");
        return model;
    }

    @RequestMapping(value = "/registration", method = {RequestMethod.POST})
    public String registerPost(@ModelAttribute("userDto") UserRegistrationRequest request,
                               ModelMap model) {
        UserRegistrationResponse response = registrationService.register(request);
        if (!response.getErrors().isEmpty()) {
            for (Error error : response.getErrors()) {
                model.addAttribute("error", "Error sukapidr");
            }
            return "registration";
        } else {
            model.addAttribute("login", response.getLogin());
            model.addAttribute("email", request.getEmail());
            return "confirmation";
        }
    }

}
