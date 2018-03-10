package at.kuchel.service;

import at.kuchel.model.*;
import at.kuchel.repostitory.IngredientRepository;
import at.kuchel.repostitory.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public void createRecipe(Recipe recipe) {
        //TODO logic for validating the recipe comes <here>
        //TODO extract someday
        extractToControllerSomeDay(recipe);

        for (int i = 0; i < recipe.getInstructions().size(); i++) {
            Instruction instruction = recipe.getInstructions().get(i);
            instruction.setStep(String.valueOf(i + 1));
        }

        replaceIngredientIfExist(recipe);

        recipeRepository.save(recipe);
    }

    private void replaceIngredientIfExist(Recipe recipe) {

        for (RecipeIngredient recipeIngredient : recipe.getRecipeIngredients()) {
            Ingredient existingIngredient = ingredientRepository.findByName(recipeIngredient.getIngredient().getName());
            if (Objects.nonNull(existingIngredient)) {
                recipeIngredient.setIngredient(existingIngredient);
            }
        }
    }

    private void extractToControllerSomeDay(Recipe recipe) {
        for (RecipeIngredient recipeIngredient : recipe.getRecipeIngredients()) {
            recipeIngredient.setRecipe(recipe);
        }

        for (Instruction instruction : recipe.getInstructions()) {
            instruction.setRecipe(recipe);
        }
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findOne(id);
    }

    public Recipe getRecipeByName(String name) {
        return recipeRepository.findByName(name);
    }

    public List<Recipe> getRecipeByUser(User user) {
        return recipeRepository.findRecipeByUser(user);
    }
}
