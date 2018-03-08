package at.kuchel.service;

import at.kuchel.model.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredient();
    List<Ingredient> getIngredientsStartsWith(String search);
    List<Ingredient> getIngredientsWithStatus(Ingredient.Status status);
}
