package at.kuchel.service;

import at.kuchel.model.Ingredient;
import at.kuchel.model.Instruction;
import at.kuchel.model.Recipe;
import at.kuchel.model.User;
import at.kuchel.repostitory.IngredientRepository;
import at.kuchel.repostitory.InstructionRepository;
import at.kuchel.repostitory.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Objects;

@Service("recipeService")
@Transactional
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private InstructionRepository instructionRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void createRecipe(Recipe recipe) {
        //TODO logic for validating the recipe comes <here>
        //Dummy remove someday
        Instruction tmp = new Instruction();
        tmp.setInstruction("step bla");
        tmp.setStep("1");

        recipe.addInstruction(tmp);
        tmp.setRecipe(recipe);
//
//        for (Ingredient ingredient : recipe.getIngredients()) {
//            System.out.println(String.format("Ingrdient: %s ", ingredient.getName()));
//        }
//
//
//        //Instruction Persist
//        for (Instruction instruction : recipe.getInstructions()) {
//            instructionRepository.save(instruction);
//        }
//
//        //Ingredient Persist
//        for (Ingredient ingredient : recipe.getIngredients()) {
//            Ingredient existingIngredient = ingredientRepository.findByName(ingredient.getName());
//            if (Objects.isNull(existingIngredient)) {
//                ingredient.addRecipe(recipe);
//                ingredientRepository.save(ingredient);
//            } else {
//                existingIngredient.addRecipe(recipe);
//                //todo replace created ingredient with ingredient from db in recipe.ingridients
//
//                ingredientRepository.save(existingIngredient);
//            }
//        }

        recipeRepository.save(recipe);

    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findOne(id);
    }

    @Override
    public Recipe getRecipeByName(String name) {
        return recipeRepository.findByName(name);
    }

    @Override
    public List<Recipe> getRecipeByUser(User user) {
        throw new NotImplementedException();
    }

}
