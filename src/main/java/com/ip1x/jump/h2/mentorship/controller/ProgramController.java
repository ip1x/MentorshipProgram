package com.ip1x.jump.h2.mentorship.controller;

import com.ip1x.jump.h2.mentorship.model.Program;
import com.ip1x.jump.h2.mentorship.exception.ResponseNotFoundException;
import com.ip1x.jump.h2.mentorship.service.impl.ProgramService;
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
@RequestMapping("/programs")
public class ProgramController {

    @Autowired
    private ProgramService programService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showProgramPage(Model model) {
        model.addAttribute("program", new Program());
        return "createProgram";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProgram(@Valid Program program, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView("programs");
        if (bindingResult.hasErrors()) {
            return "createProgram";
        }
        programService.save(program);
        return "redirect:/programs/get/all";
    }

    @RequestMapping(value = "/edit/{id:[\\d]+}", method = RequestMethod.GET)
    public ModelAndView showEditPageForProgramById(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("editProgram");
        Program program = programService.findById(id);
        if (program == null) {
            throw new ResponseNotFoundException("Program with id=" + id + " doesn't exist");
        }
        model.addObject("program", programService.findById(id));
        return model;
    }

    @RequestMapping(value = "/edit/{id:[\\d]+}", method = RequestMethod.POST)
    public String editProgramById(@Valid Program program, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView("programs");
        if (bindingResult.hasErrors()) {
            model.addObject("program", programService.findById(program.getId()));
            return "editProgram";
        }
        programService.save(program);
        return "redirect:/programs/get/all";
    }

    @RequestMapping(value = "/get/{id:[\\d]+}", method = RequestMethod.GET)
    public ModelAndView getProgramById(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("programs");
        Program program = programService.findById(id);
        if (program == null) {
            throw new ResponseNotFoundException("Program with id=" + id + " doesn't exist");
        }
        model.addObject("program", programService.findById(id));
        model.addObject("users", userService.findAll());
        return model;
    }

    // RESTful method
    @RequestMapping(value = "/get/all", produces = {"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Program> getAllPrograms() {
        return programService.findAll();
    }

    // View-based method
    @RequestMapping("/get/all")
    public String getAllPrograms(Model model) {
        model.addAttribute("programs", programService.findAll());
        return "programs";
    }

    @RequestMapping(value = "/delete/{id:[\\d]+}", method = RequestMethod.POST)
    public String deleteProgram(@PathVariable("id") Long id) {
        programService.deleteById(id);
        return "redirect:/programs/get/all";
    }

    @ExceptionHandler(ResponseNotFoundException.class)
    public ModelAndView handleError(Exception ex) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("message", ex.getMessage());
        return model;
    }
}
