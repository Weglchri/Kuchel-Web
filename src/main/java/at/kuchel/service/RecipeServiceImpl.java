package at.kuchel.service;

import at.kuchel.model.Instruction;
import at.kuchel.model.Recipe;
import at.kuchel.model.RecipeIngredient;
import at.kuchel.model.User;
import at.kuchel.repostitory.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Transactional
@Service("recipeService")
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void createRecipe(Recipe recipe) {
        //TODO logic for validating the recipe comes <here>
        //START Dummy remove someday  ###########################################
        Instruction tmp = new Instruction();
        tmp.setInstruction("step bla");
        tmp.setStep("1");

        recipe.addInstruction(tmp);

        //this must be done inside thymeleaf or controller
        for (RecipeIngredient recipeIngredient : recipe.getRecipeIngredients()) {
            recipeIngredient.setAmount("1");
            recipeIngredient.setQualifier(RecipeIngredient.Type.dag);
            recipeIngredient.setRecipe(recipe);
        }

        for (RecipeIngredient recipeIngredient : recipe.getRecipeIngredients()) {
            System.out.println("amount: " + recipeIngredient.getAmount());
            System.out.println("qualifier: " + recipeIngredient.getQualifier());
            System.out.println("recipe: " + recipeIngredient.getRecipe());


            System.out.println("ingredientName: " + recipeIngredient.getIngredient().getName());
        }

        //END Dummy remove someday  ###########################################

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
