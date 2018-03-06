package at.kuchel.controller;

import at.kuchel.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

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

    @RequestMapping(value = "/my-recipes", method = RequestMethod.GET ,params = "id")
    public String listmyRecipes(Model model, @RequestParam("id") long id) {

        //dirty session management (same as in Dashboard)
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        model.addAttribute("my-recipes", recipeService.getRecipeByUsername(username));
        System.out.println(recipeService.getRecipeByUsername(username));

        return "my-recipes-overview";
    }
}
