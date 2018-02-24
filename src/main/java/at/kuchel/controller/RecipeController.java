package at.kuchel.controller;

import at.kuchel.service.RecipeService;
import at.kuchel.util.UserRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserRetriever userRetriever;

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public String listRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes-overview";
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.GET ,params = "id")
    public String listRecipes(Model model, @RequestParam("id") long id) {
        model.addAttribute("recipe", recipeService.getRecipeById(id));
        return "recipes-detailed";
    }
}
