package at.kuchel.controller;

import at.kuchel.model.Ingredient;
import at.kuchel.model.Recipe;
import at.kuchel.model.User;
import at.kuchel.service.IngredientService;
import at.kuchel.service.RecipeService;
import at.kuchel.util.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Objects;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private SessionHelper sessionHelper;

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public ModelAndView listRecipes() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recipes", recipeService.getAllRecipes());
        modelAndView.setViewName("recipes-overview");
        return modelAndView;
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.GET, params = "id")
    public ModelAndView listRecipes(@RequestParam("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recipe", recipeService.getRecipeById(id));
        modelAndView.setViewName("recipes-detailed");
        return modelAndView;
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.POST)
    public ModelAndView createRecipe(@Valid Recipe recipe, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        //todo check befor upload if name exist
        Recipe existingRecipe = recipeService.getRecipeByName(recipe.getName());
        if (!Objects.isNull(existingRecipe)) {
            bindingResult
                    .rejectValue("recipe", "error.recipe",
                            "Es existiert bereits ein Rezept mit diesem Namen");
        }
        recipe.setUser(sessionHelper.getCurrentUser());
        recipeService.createRecipe(recipe);
        modelAndView.addObject("recipe", recipe);
        modelAndView.addObject("successMessage", String.format("Rezept %s wurde erfolgreich hinzugefügt", recipe.getName()));
        modelAndView.setViewName("recipes-detailed");
        return modelAndView;
    }

    @RequestMapping(value = "/recipes/new", method = RequestMethod.GET)
    public ModelAndView getNewRecipe() {
        ModelAndView modelAndView = new ModelAndView();
        Recipe recipe = new Recipe();
        recipe.addIngredient(new Ingredient());
        modelAndView.addObject("recipe", recipe);
        modelAndView.addObject("acceptedIngredients", ingredientService.getIngredientsWithStatus(Ingredient.Status.APPROVED));
        modelAndView.setViewName("create-recipe");
        return modelAndView;
    }

    @RequestMapping(value = "/recipes", params = {"addRowIngredient"})
    public ModelAndView addRowIngredient(Recipe recipe) {
        ModelAndView modelAndView = new ModelAndView();
        recipe.addIngredient(new Ingredient());
        modelAndView.addObject("acceptedIngredients", ingredientService.getIngredientsWithStatus(Ingredient.Status.APPROVED));
        modelAndView.addObject("recipe", recipe);
        modelAndView.setViewName("create-recipe");
        return modelAndView;
    }

    @RequestMapping(value = "/recipes", params = {"removeRowIngredient"})
    public ModelAndView removeRowIngredient(Recipe recipe,
                                            final HttpServletRequest req, @RequestParam("removeRowIngredient") String id) {
        ModelAndView modelAndView = new ModelAndView();
        final Integer rowId = Integer.valueOf(id);
        Ingredient ingredient = recipe.getIngredients().get(rowId);
        recipe.getIngredients().remove(ingredient);
        modelAndView.addObject("acceptedIngredients", ingredientService.getIngredientsWithStatus(Ingredient.Status.APPROVED));
        modelAndView.addObject("recipe", recipe);
        modelAndView.setViewName("create-recipe");
        return modelAndView;
    }

    @RequestMapping(value = "/my-recipes", method = RequestMethod.GET)
    public ModelAndView listmyRecipes() {
        ModelAndView modelAndView = new ModelAndView();
        User user = sessionHelper.getCurrentUser();
        modelAndView.addObject("my-recipes", recipeService.getRecipeByUser(user));
        modelAndView.setViewName("my-recipes-overview");
        return modelAndView;
    }
}
