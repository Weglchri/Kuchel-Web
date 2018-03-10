package at.kuchel.service;

import at.kuchel.model.Ingredient;
import at.kuchel.model.Recipe;
import at.kuchel.repostitory.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    private List<Ingredient> ingredients = new ArrayList<>();

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getAllIngredient() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        if (ingredients.isEmpty()) {
            setIngredients(ingredients);
        }
        return ingredients;
    }

    @Override
    public List<Ingredient> getIngredientsStartsWith(String search) {
        if (ingredients.isEmpty()) {
            setIngredients(ingredientRepository.findAll());
        }
        return ingredients.stream().filter(ingredient -> ingredient.getName().startsWith(search)).collect(Collectors.toList());
    }

    @Override
    public List<Ingredient> getIngredientsWithStatus(Ingredient.Status status) {
        return ingredientRepository.findByStatus(status);
    }

    @Override
    public List<Ingredient> getAllIngredientsWithStatusReducedByChosenOnes(Ingredient.Status status, Recipe recipe) {
        List<Ingredient> ingredientsFromDb = getIngredientsWithStatus(status);
        List<Ingredient> ingredients = recipe.getIngredients();

        return ingredientsFromDb.stream().filter(ingredient -> ingredients.stream().noneMatch(ingredient1 -> ingredient.getName().equals(ingredient1.getName()))).collect(Collectors.toList());
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
