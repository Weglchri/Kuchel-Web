package at.kuchel.service;

import at.kuchel.exception.KuchelException;
import at.kuchel.model.*;
import at.kuchel.repostitory.ImageRepository;
import at.kuchel.repostitory.IngredientRepository;
import at.kuchel.repostitory.InstructionRepository;
import at.kuchel.repostitory.RecipeRepository;
import at.kuchel.util.SessionHelper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private InstructionRepository instructionRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private SessionHelper sessionHelper;

    public void createRecipe(Recipe recipe) {
        //TODO extract someday
        extractToControllerSomeDay(recipe);
        for (int i = 0; i < recipe.getInstructions().size(); i++) {
            Instruction instruction = recipe.getInstructions().get(i);
            instruction.setStep(String.valueOf(i + 1));
        }
        recipe.setCreationDate(new Date());
        replaceIngredientIfExist(recipe);
        recipeRepository.save(recipe);
    }

    public void updateRecipe(Recipe recipe) {

        Recipe storedRecipe = getRecipeById(recipe.getId());
        updateFieldValues(recipe, storedRecipe);


        extractToControllerSomeDay(recipe);
        //todo number steps now
        for (int i = 0; i < recipe.getInstructions().size(); i++) {
            Instruction instruction = recipe.getInstructions().get(i);
            instruction.setStep(String.valueOf(i + 1));
        }

        replaceIngredientIfExist(recipe);
        recipeRepository.save(recipe);
    }

    private void updateFieldValues(Recipe recipe, Recipe storedRecipe) {
        recipe.setCreationDate(storedRecipe.getCreationDate());
        recipe.setImage(storedRecipe.getImages());
        recipe.setModifiedDate(new Date());
        recipe.setUser(sessionHelper.getCurrentUser());

        updateInstructionValues(recipe.getInstructions(), storedRecipe.getInstructions());
        updateRecipeIngredientValues(recipe.getRecipeIngredients(), storedRecipe.getRecipeIngredients());
    }

    private void updateRecipeIngredientValues(List<RecipeIngredient> recipeIngredients, List<RecipeIngredient> recipeIngredients1) {


    }

    private void updateInstructionValues(List<Instruction> instructions, List<Instruction> storedInstructions) {
        List<Instruction> instructionsToDelete = new ArrayList<>();
        List<Instruction> instructionsToUpdate = new ArrayList<>();

        //todo find entries to remove
        //find entries to keep
        //find entries to update


        for (Instruction storedInstruction : storedInstructions) {
            boolean remove = true;
            for (Instruction instruction : instructions) {
                if (instruction.getId().equals(storedInstruction.getId())) {
                    remove = false;

                    if (isUpdateNeeded(instruction, storedInstruction)) {
                        instructionsToUpdate.add(instruction);
                    }
                }
            }
            if (remove) {
                instructionsToDelete.add(storedInstruction);
            }
        }

        instructionRepository.delete(instructionsToDelete);
//        ingredientRepository.save(in)

    }

    private boolean isUpdateNeeded(Instruction instruction, Instruction storedInstruction) {
        if (!instruction.getStep().equals(storedInstruction.getStep())) {
            return true;
        }

        if (!instruction.getDescription().equals(storedInstruction.getDescription())) {
            return true;
        }

        return false;
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
        List<Recipe> all = recipeRepository.findAll();
        for (Recipe recipe : all) {
            storeImage(recipe);
        }

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

    private void storeImage(Recipe recipe) {

        java.io.File file;
        byte[] bytes = null;
        try {
            file = new java.io.File("testfile.jpg");

            bytes = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        recipe.getImages().get(0).setModifiedDate(new Date());
        recipe.getImages().get(0).setData(bytes);

        imageRepository.saveAndFlush(recipe.getImages().get(0));

    }

}
