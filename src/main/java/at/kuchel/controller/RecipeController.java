package at.kuchel.controller;

import at.kuchel.Context;
import at.kuchel.model.*;
import at.kuchel.service.IngredientService;
import at.kuchel.service.RecipeService;
import at.kuchel.util.SessionHelper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Objects;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@RequestMapping(Context.GUI_API)
public class RecipeController {

    private static final Logger LOG = getLogger(RecipeController.class);

    private RecipeService recipeService;
    private IngredientService ingredientService;
    private SessionHelper sessionHelper;

    @Autowired
    public RecipeController(RecipeService recipeService, IngredientService ingredientService, SessionHelper sessionHelper) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.sessionHelper = sessionHelper;
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public ModelAndView listRecipes() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recipes", recipeService.getAllRecipes());
        modelAndView.setViewName("recipes-overview");
        return modelAndView;
    }

    @RequestMapping(value = "/myrecipes", method = RequestMethod.GET)
    public ModelAndView listAllMyRecipes() {
        ModelAndView modelAndView = new ModelAndView();
        User user = sessionHelper.getCurrentUser();
        modelAndView.addObject("recipes", recipeService.getRecipeByUser(user));
        modelAndView.addObject("personaloverview", true);
        modelAndView.setViewName("recipes-overview");
        return modelAndView;
    }

    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
    public ModelAndView listRecipes(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recipe", recipeService.getRecipeById(Long.parseLong(id)));
        modelAndView.setViewName("recipes-detailed");
        return modelAndView;
    }

    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteRecipe(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        Recipe recipe = recipeService.getRecipeById(Long.parseLong(id));

        if (Objects.nonNull(recipe))
            recipeService.deleteRecipe(recipe);

        modelAndView.addObject("recipes", recipeService.getAllRecipes());
        modelAndView.setViewName("recipes-overview");
        return modelAndView;
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.POST)
    public ModelAndView createRecipe(@Valid Recipe recipe, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        Recipe existingRecipe = recipeService.getRecipeByName(recipe.getName());

        if (Objects.nonNull(existingRecipe)) {
            bindingResult
                    .rejectValue("name", "error.name",
                            "Es existiert bereits ein Rezept mit diesem Namen");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("create-recipe");
        } else {
            recipe.setUser(sessionHelper.getCurrentUser());
            recipeService.createRecipe(recipe);
            modelAndView.addObject("recipe", recipe);
            modelAndView.addObject("alertMessage", String.format("%s wurde erfolgreich hinzugefügt", recipe.getName()));
            modelAndView.setViewName("recipes-detailed");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/recipes/new", method = RequestMethod.GET)
    public ModelAndView getNewRecipe() {
        ModelAndView modelAndView = new ModelAndView();
        Recipe recipe = new Recipe();
        addObjectsForCreateRecipeView(modelAndView, recipe);
        return modelAndView;
    }


    @RequestMapping(value = "/recipes", params = {"addRowIngredient"})
    public ModelAndView addRowIngredient(Recipe recipe) {
        ModelAndView modelAndView = new ModelAndView();
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setIngredient(new Ingredient());
        recipe.addRecipeIngredient(recipeIngredient);
        addObjectsForCreateRecipeView(modelAndView, recipe);
        return modelAndView;
    }

    @RequestMapping(value = "/recipes", params = {"removeRowIngredient"})
    public ModelAndView removeRowIngredient(Recipe recipe, final HttpServletRequest req, @RequestParam("removeRowIngredient") String id) {
        ModelAndView modelAndView = new ModelAndView();
        final Integer rowId = Integer.valueOf(id);
        RecipeIngredient recipeIngredient = recipe.getRecipeIngredients().get(rowId);
        recipe.getRecipeIngredients().remove(recipeIngredient);
        addObjectsForCreateRecipeView(modelAndView, recipe);
        return modelAndView;
    }

    @RequestMapping(value = "/recipes", params = {"addRowInstruction"})
    public ModelAndView addRowInstruction(Recipe recipe) {
        ModelAndView modelAndView = new ModelAndView();
        recipe.addInstruction(new Instruction());
        addObjectsForCreateRecipeView(modelAndView, recipe);
        return modelAndView;
    }

    @RequestMapping(value = "/recipes", params = {"removeRowInstruction"})
    public ModelAndView removeRowInstruction(Recipe recipe, final HttpServletRequest req, @RequestParam("removeRowInstruction") String id) {
        ModelAndView modelAndView = new ModelAndView();
        final Integer rowId = Integer.valueOf(id);
        Instruction instruction = recipe.getInstructions().get(rowId);
        recipe.getInstructions().remove(instruction);
        addObjectsForCreateRecipeView(modelAndView, recipe);
        return modelAndView;
    }

    /*
        Update methods
    */

    @RequestMapping(value = "/recipes/{id}/update", method = RequestMethod.GET)
    public ModelAndView getUpdateRecipe(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        Recipe recipeToUpdate = recipeService.getRecipeById(Long.parseLong(id));
        modelAndView.addObject("recipe", recipeToUpdate);
        modelAndView.setViewName("update-recipe");
        return modelAndView;
    }

    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.POST)
    public ModelAndView updateRecipe( @Valid Recipe recipe, BindingResult bindingResult) {
        LOG.info("updateRowInstruction");

        ModelAndView modelAndView = new ModelAndView();
        Recipe existingRecipe = recipeService.getRecipeByName(recipe.getName());

        if (Objects.nonNull(existingRecipe) && !existingRecipe.getId().equals(recipe.getId())) {
            bindingResult
                    .rejectValue("name", "error.name",
                            "Es existiert bereits ein anderes Rezept mit diesem Namen");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("update-recipe");
        } else {
            recipeService.updateRecipe(recipe);
            modelAndView.addObject("recipe", recipe);
            modelAndView.addObject("alertMessage", String.format("%s wurde erfolgreich geändert", recipe.getName()));
            modelAndView.setViewName("recipes-detailed");
        }
        return modelAndView;
    }


    //TODO: methods are the same as creational methods refactoring in the future necessary

     /*
         Methods for update view
     */

    @RequestMapping(value = "/recipes/{id}", params = {"updateRowIngredient"})
    public ModelAndView updateRowIngredient(Recipe recipe) {
        LOG.info("updateRowIngredient");
        ModelAndView modelAndView = new ModelAndView();
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setIngredient(new Ingredient());
        recipe.addRecipeIngredient(recipeIngredient);
        addObjectsForUpdateRecipeView(modelAndView, recipe);
        return modelAndView;
    }

    @RequestMapping(value = "/recipes/{id}", params = {"removeUpdateRowIngredient"})
    public ModelAndView removeUpdateRowIngredient(Recipe recipe, final HttpServletRequest req, @RequestParam("removeUpdateRowIngredient") String id) {
        LOG.info("removeUpdateRowIngredient");
        ModelAndView modelAndView = new ModelAndView();
        final Integer rowId = Integer.valueOf(id);
        RecipeIngredient recipeIngredient = recipe.getRecipeIngredients().get(rowId);
        recipe.getRecipeIngredients().remove(recipeIngredient);
        addObjectsForUpdateRecipeView(modelAndView, recipe);
        return modelAndView;
    }

    @RequestMapping(value = "/recipes/{id}", params = {"updateRowInstruction"})
    public ModelAndView updateRowInstruction(Recipe recipe) {
        LOG.info("updateRowInstruction");
        ModelAndView modelAndView = new ModelAndView();
        recipe.addInstruction(new Instruction());
        addObjectsForUpdateRecipeView(modelAndView, recipe);
        return modelAndView;
    }

    @RequestMapping(value = "/recipes/{id}", params = {"removeUpdateRowInstruction"})
    public ModelAndView removeUpdateRowInstruction(Recipe recipe, final HttpServletRequest req, @RequestParam("removeUpdateRowInstruction") String id) {
        LOG.info("removeUpdateRowInstruction");
        ModelAndView modelAndView = new ModelAndView();
        final Integer rowId = Integer.valueOf(id);
        Instruction instruction = recipe.getInstructions().get(rowId);
        recipe.getInstructions().remove(instruction);
        addObjectsForUpdateRecipeView(modelAndView, recipe);
        return modelAndView;
    }

    /*
        Helper methods for create and update view
    */

    private void addObjectsForCreateRecipeView(ModelAndView modelAndView, Recipe recipe) {
        modelAndView.addObject("acceptedIngredients", ingredientService.getAllIngredientsWithStatusReducedByChosenOnes(Ingredient.Status.APPROVED, recipe));
        modelAndView.addObject("recipeIngredientTypes", Arrays.asList(RecipeIngredient.Type.values()));
        modelAndView.addObject("recipe", recipe);
        modelAndView.setViewName("create-recipe");
    }

    private void addObjectsForUpdateRecipeView(ModelAndView modelAndView, Recipe recipe) {
        modelAndView.addObject("acceptedIngredients", ingredientService.getAllIngredientsWithStatusReducedByChosenOnes(Ingredient.Status.APPROVED, recipe));
        modelAndView.addObject("recipeIngredientTypes", Arrays.asList(RecipeIngredient.Type.values()));
        modelAndView.addObject("recipe", recipe);
        modelAndView.setViewName("update-recipe");
    }
}