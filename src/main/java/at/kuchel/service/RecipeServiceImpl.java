package at.kuchel.service;

import at.kuchel.model.Recipe;
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
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findOne(id);
    }

    @Override
    public List<Recipe> getRecipeByUsername(String username) {
        throw new NotImplementedException();
    }
}
