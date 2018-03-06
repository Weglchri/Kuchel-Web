package at.kuchel.service;

import at.kuchel.model.Recipe;
import at.kuchel.model.User;
import at.kuchel.repostitory.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void createRecipe(Recipe recipe) {
        //logic for validating the recipe comes <here>
        recipeRepository.saveAndFlush(recipe);
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
    public List<Recipe> getRecipeByUser(User user) {
        throw new NotImplementedException();
    }

}
