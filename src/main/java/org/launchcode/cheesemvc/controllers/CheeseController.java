package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("cheese")
public class CheeseController {
// static so all methods inside this class can use it
    //replaced arraylist with hashmap in class 4 exercises to add description of cheese
    // key: value = cheese: description
    static HashMap<String, String> cheeses = new HashMap<>();

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        //cheeses.add(cheeseName);
        cheeses.put(cheeseName, cheeseDescription);
        return "redirect:";
    }

    //removing added in studio CheeseMVC
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String displayDeleteCheeseForm(Model model){
        model.addAttribute("title", "Delete Cheese");
        model.addAttribute("cheeses", cheeses);

        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String DeleteCheeseForm(@RequestParam ArrayList<String> cheeseName) {

        for (String cheese : cheeseName){
            cheeses.remove(cheese);
        }
        return "redirect:";

    }
}
