package at.kuchel.service.rest;

import at.kuchel.api.RecipeResponse;
import at.kuchel.mapper.RecipeMapper;
import at.kuchel.model.Recipe;
import at.kuchel.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceApi {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeMapper recipeMapper;

    public List<RecipeResponse> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();

        return recipes.stream().map(recipe -> recipeMapper.map(recipe)).collect(Collectors.toList());
    }
}
