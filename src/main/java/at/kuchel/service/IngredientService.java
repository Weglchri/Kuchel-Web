package at.kuchel.service;

import at.kuchel.model.Ingredient;
import at.kuchel.model.Recipe;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredient();
    List<Ingredient> getIngredientsStartsWith(String search);
    List<Ingredient> getIngredientsWithStatus(Ingredient.Status status);
    List<Ingredient> getAllIngredientsWithStatusReducedByChosenOnes(Ingredient.Status status,Recipe recipe);
}
