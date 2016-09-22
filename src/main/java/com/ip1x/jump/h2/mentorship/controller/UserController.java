package com.ip1x.jump.h2.mentorship.controller;

import com.ip1x.jump.h2.mentorship.entity.Level;
import com.ip1x.jump.h2.mentorship.entity.User;
import com.ip1x.jump.h2.mentorship.exception.ResponseNotFoundException;
import com.ip1x.jump.h2.mentorship.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showUserPage(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("levelOptions", Level.values());
        return "createUser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView("users");
        if(bindingResult.hasErrors()){
            return "createUser";
        }
        userService.save(user);
        return "redirect:/users/get/all";
    }

    @RequestMapping(value = "/edit/{id:[\\d]+}", method = RequestMethod.GET)
    public ModelAndView showEditPageForUserById(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("editUser");
        User user = userService.findById(id);
        if(user == null){
            throw new ResponseNotFoundException("User with id=" + id + " doesn't exist");
        }
        model.addObject("user", userService.findById(id));
        model.addObject("levelOptions", Level.values());
        return model;
    }

    @RequestMapping(value = "/edit/{id:[\\d]+}", method = RequestMethod.POST)
    public String editUserById(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView("users");
        if(bindingResult.hasErrors()){
            model.addObject("user", userService.findById(user.getId()));
            return "editUser";
        }
        userService.save(user);
        return "redirect:/users/get/all";
    }

    @RequestMapping(value ="/get/{id:[\\d]+}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("users");
        User user = userService.findById(id);
        if(user == null){
            throw new ResponseNotFoundException("User with id=" + id + " doesn't exist");
        }
        model.addObject("user", userService.findById(id));
        return model;
    }

    // RESTful method
    @RequestMapping(value="/get/all", produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<User> getAllUsers(){
        return userService.findAll();
    }

    // View-based method
    @RequestMapping("/get/all")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping(value = "/delete/{id:[\\d]+}",method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users/get/all";
    }

    @ExceptionHandler(ResponseNotFoundException.class)
    public ModelAndView handleError(Exception ex) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("message", ex.getMessage());
        return model;
    }
}
