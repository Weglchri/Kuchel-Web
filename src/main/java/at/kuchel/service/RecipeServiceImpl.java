package at.kuchel.service;

import at.kuchel.model.Ingredient;
import at.kuchel.model.Recipe;
import at.kuchel.model.User;
import at.kuchel.repostitory.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void createRecipe(Recipe recipe) {
        //TODO logic for validating the recipe comes <here>
        Ingredient ingredient = new Ingredient();
        ingredient.setDescription("desc");
        ingredient.setName("waffel");

        Set<Ingredient> ingredients= new HashSet<>();
        ingredients.add(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("aff");
        ingredient.setName("Ei");

        ingredients.add(ingredient);
        recipe.setIngredients(ingredients);

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
    public Recipe getRecipeByName(String name) {
        return recipeRepository.findByName(name);
    }

    @Override
    public List<Recipe> getRecipeByUser(User user) {
        throw new NotImplementedException();
    }

}
