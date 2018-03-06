package at.kuchel.service;

import at.kuchel.model.Recipe;

import java.util.List;


public interface RecipeService {

    void createRecipe(Recipe recipe);
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);

    //TODO: get recipe of user!
    List<Recipe> getRecipeByUsername(String username);
}
