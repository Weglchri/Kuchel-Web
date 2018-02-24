package at.kuchel.controller;

import at.kuchel.service.RecipeService;
import at.kuchel.util.UserRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserRetriever userRetriever;

    @RequestMapping(value = "/recipe", method = RequestMethod.GET)
    public String listStudent(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipe";
    }
}
