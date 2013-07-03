package controller;

import domain.User;
import service.UserService;
import validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Locale;

@Controller
public class UserController {
    public UserController() {
        Locale.setDefault(Locale.ENGLISH);
    }
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping("/")
    public String foo() {
        return "redirect:user";
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView get() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("users");
        mav.addObject("users", userService.getAll());
        mav.addObject("user", new User());
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("user") User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors())
            return "/users";
        userService.update(user);
        return "redirect:/user";
    }


    @RequestMapping(value = "/user/{id}/{action}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, @PathVariable String action, Model model) {
        
        User user = userService.getById(Long.parseLong(id));

        if (action.equals("delete")) {
            userService.delete(user);
            return "redirect:/user";
        }

        if (action.equals("edit"))
            model.addAttribute("user", user);
        return "/users";

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
