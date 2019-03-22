package com.endava.demo.controller;

import com.endava.demo.entity.Intern;
import com.endava.demo.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.endava.demo.entity.InternStreams.NET;

@Controller
public class InternController {

    @Autowired
    private InternService internService;

    @GetMapping("/newForm")
    public String secondView(Model model) {
        model.addAttribute("intern", new Intern("Serghei", 27, NET));
        return "newForm";
    }

    @RequestMapping(value = "/newForm", method = RequestMethod.POST)
    public String fillForm(@ModelAttribute Intern intern) {
        internService.add(intern);
        return "redirect:/";
    }

    @RequestMapping("/newFormUpdate/{id}")
    public String secondViewUpdate(Model model,@PathVariable int id ) {

        model.addAttribute("intern", internService.update(id));
        return "newFormUpdate";
    }

    @RequestMapping(value = "/newFormUpdate", method = RequestMethod.POST)
    public String updateForm(@ModelAttribute Intern intern) {
        internService.addAfterUpdate(intern);
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteIntern(@PathVariable int id) {

        internService.delete(id);
        return "redirect:/";
    }

    @GetMapping(value = "/update/{id}")
    public String updateIntern(@PathVariable int id) {
        System.out.println(internService.update(id));
        internService.update(id);
        return "redirect:/newFormUpdate/{id}";
    }
}
