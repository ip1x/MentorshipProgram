package com.ip1x.jump.h2.mentorship.controller;

import com.ip1x.jump.h2.mentorship.entity.Level;
import com.ip1x.jump.h2.mentorship.entity.User;
import com.ip1x.jump.h2.mentorship.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showUserPage(Model model){
        model.addAttribute("mode", "add");
        model.addAttribute("user", new User());
        return "users";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        ModelAndView model = new ModelAndView("users");
        userService.save(user);
        return "redirect:/users/get/all";
    }

    @RequestMapping(value = "/edit/{id:[\\d]+}", method = RequestMethod.GET)
    public ModelAndView showEditPageForUserById(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("users");
        model.addObject("mode", "edit");
        model.addObject("user", userService.findById(id));
        return model;
    }

    @RequestMapping(value = "/edit/{id:[\\d]+}", method = RequestMethod.POST)
    public String editUserById(@ModelAttribute("user") User user) {
        ModelAndView model = new ModelAndView("users");
        userService.save(user);
        return "redirect:/users/get/all";
    }

    @RequestMapping(value ="/get/{id:[\\d]+}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("users");
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
        userService.save(new User("1","1", Level.D1,"java", LocalDate.of(1996,04,12)));
        return "users";
    }

    @RequestMapping(value = "/delete/{id:[\\d]+}",method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.delete(user);
        return "redirect:/users/get/all";
    }
}
