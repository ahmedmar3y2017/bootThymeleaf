package com.example.demo;

import com.example.demo.Dao.personRepo;
import com.example.demo.Entities.person;
import com.example.demo.Message.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@CrossOrigin
public class HelloController implements ErrorController {


    @Autowired
    personRepo personRepo;

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("message", "ahmed mar3y");
        return modelAndView;
    }

    @RequestMapping("/listPerson")
    public ModelAndView personList() {
        ModelAndView modelAndView = new ModelAndView("listPerson");
        List<person> personList = personRepo.findAll();
        modelAndView.addObject("persons", personList);

        return modelAndView;
    }

    @RequestMapping("/addPerson")
    public ModelAndView addPersonPage() {
        ModelAndView modelAndView = new ModelAndView("addPerson");
        modelAndView.addObject("person", new person());

        return modelAndView;
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public ModelAndView addPerson(@Valid person person, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        // add to database
//        if (person.getName() != null && person.getName().length() > 0 //
//                && person.getAddress() != null && person.getAddress().length() > 0) {
        if (!result.hasErrors()) {
            modelAndView.setViewName("redirect:/listPerson");
            personRepo.save(person);
            return modelAndView;
        }
//        }
        modelAndView.setViewName("addPerson");
        modelAndView.addObject("errorMessage", "First Name & Last Name is required!");
        return modelAndView;

    }


    // *********************************** ajax **************************
    //    @GetMapping(value = "/all")ResponseEntity<?>
    @RequestMapping("/all")
    public ResponseEntity<?> getResource() {
        Response response = new Response("Done", personRepo.findAll());
        return ResponseEntity.ok(response);
    }

    @RequestMapping("/allPersons")
    public List<person> getResourcePersons() {
        return personRepo.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> postCustomer(@RequestBody @Valid person person, BindingResult result) {
        if (result.hasErrors()) {


        }

        System.err.println("Done Request" + person.getName() + person.getAddress());
        personRepo.save(person);
        // Create Response Object
        Response response = new Response("Done", person);
        return ResponseEntity.ok(response);
    }

    // ***************************** security ***********************

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("message", "ahmed mar3y");
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView("admin");
        return modelAndView;
    }

    @GetMapping("/user")
    public ModelAndView user() {
        ModelAndView modelAndView = new ModelAndView("user");
        return modelAndView;
    }

    @GetMapping("/about")
    public ModelAndView about() {
        ModelAndView modelAndView = new ModelAndView("about");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }


}
