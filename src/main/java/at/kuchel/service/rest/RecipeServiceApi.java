package at.kuchel.service.rest;

import at.kuchel.api.LastSyncDateRequest;
import at.kuchel.api.RecipeDetailedResponse;
import at.kuchel.exception.KuchelApiException;
import at.kuchel.exception.KuchelException;
import at.kuchel.mapper.RecipeMapper;
import at.kuchel.model.Recipe;
import at.kuchel.service.RecipeService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class RecipeServiceApi {
    private static final Logger LOG = getLogger(RecipeServiceApi.class);

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeMapper recipeMapper;

    public List<RecipeDetailedResponse> getAllRecipes() {
        LOG.info("Retrieve all recipes");
        List<Recipe> recipes = recipeService.getAllRecipes();
        return recipes.stream().map(recipe -> recipeMapper.mapToDetail(recipe)).collect(Collectors.toList());
    }

    public RecipeDetailedResponse getRecipeById(String id) {
        LOG.info("Retrieve recipe with id '{}'", id);

        try {
            Recipe recipe = recipeService.getRecipeById(Long.parseLong(id));
            return recipeMapper.mapToDetail(recipe);
        } catch (KuchelException ex) {
            throw new KuchelApiException(ex);

        }
    }

    public List<RecipeDetailedResponse> getAllRecipes(LastSyncDateRequest lastSyncDateRequest) {
        LOG.info("Retrieve recipe with sync date '{}'", lastSyncDateRequest.getLastSyncDate());
        List<Recipe> recipes = recipeService.getAllRecipes();
        return recipes.stream()
                .filter(recipe -> recipe.getModifiedDate().after(lastSyncDateRequest.getLastSyncDate()))
                .map(recipe -> recipeMapper.mapToDetail(recipe))
                .collect(Collectors.toList());
    }
}
