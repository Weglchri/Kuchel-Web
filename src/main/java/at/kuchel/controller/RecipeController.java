package at.kuchel.controller;

import at.kuchel.model.Recipe;
import at.kuchel.model.User;
import at.kuchel.service.RecipeService;
import at.kuchel.util.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private SessionHelper sessionHelper;

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public String listRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes-overview";
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.GET, params = "id")
    public String listRecipes(Model model, @RequestParam("id") long id) {
        model.addAttribute("recipe", recipeService.getRecipeById(id));
        return "recipes-detailed";
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.PUT)
    public String putRecipes(@Valid Recipe recipe) {
        ModelAndView modelAndView = new ModelAndView();
        recipeService.createRecipe(recipe);
        modelAndView.addObject("successMessage", String.format("Rezept %s wurde erfolgreich hinzugefügt", recipe.getName()));
        return "recipes-detailed";
    }

    @RequestMapping(value = "/my-recipes", method = RequestMethod.GET)
    public String listmyRecipes(Model model) {
        User user = sessionHelper.getCurrentUser();
        model.addAttribute("my-recipes", recipeService.getRecipeByUser(user));
        return "my-recipes-overview";
    }
}
