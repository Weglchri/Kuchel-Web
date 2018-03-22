package at.kuchel.service;

import at.kuchel.exception.KuchelException;
import at.kuchel.model.*;
import at.kuchel.repostitory.IngredientRepository;
import at.kuchel.repostitory.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static at.kuchel.exception.KuchelErrorCode.RECIPE_NOT_FOUND;

@Transactional
@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public void createRecipe(Recipe recipe) {
        //TODO extract someday
        extractToControllerSomeDay(recipe);
        for (int i = 0; i < recipe.getInstructions().size(); i++) {
            Instruction instruction = recipe.getInstructions().get(i);
            instruction.setStep(String.valueOf(i + 1));
        }
        recipe.setCeationDate(LocalDate.now());
        replaceIngredientIfExist(recipe);
        recipeRepository.save(recipe);
    }

    public void updateRecipe(Recipe recipe) {
        //TODO extract someday
        extractToControllerSomeDay(recipe);
        for (int i = 0; i < recipe.getInstructions().size(); i++) {
            Instruction instruction = recipe.getInstructions().get(i);
            instruction.setStep(String.valueOf(i + 1));
        }
        recipe.setModifiedDate(LocalDate.now());
        replaceIngredientIfExist(recipe);
        recipeRepository.save(recipe);
    }

    private void remove(Recipe recipe) {

        Path path = Paths.get("C:/Tortelloni.jpg");
        try {
            Image image = new Image();
            image.setModifiedDate(LocalDate.now());

            image.setData(Files.readAllBytes(path));
            recipe.addImage(image);
            image.setRecipe(recipe);
        } catch (IOException e) {
            e.printStackTrace();
        }


        recipe.setDifficulty(2L);
        recipe.setDuration(70L);
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
        Recipe recipe = recipeRepository.findOne(id);

        if (Objects.nonNull(recipe)) {
            return recipe;
        }

        throw new KuchelException(RECIPE_NOT_FOUND);
    }

    public Recipe getRecipeByName(String name) {
        return recipeRepository.findByName(name);
    }

    public List<Recipe> getRecipeByUser(User user) {
        return recipeRepository.findRecipeByUser(user);
    }

    public Recipe getRecommendationRecipe() {
        throw new NotImplementedException();
    }

    public Recipe getRandomRecipe() {
        throw new NotImplementedException();
    }

    public void deleteRecipe(Recipe recipe) {
        recipeRepository.delete(recipe);
    }

}
