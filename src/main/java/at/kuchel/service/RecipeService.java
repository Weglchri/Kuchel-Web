package at.kuchel.service;

import at.kuchel.model.Recipe;
import at.kuchel.model.User;

import java.util.List;


public interface RecipeService {

    void createRecipe(Recipe recipe);
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);
    List<Recipe> getRecipeByUser(User user);
}
