package at.kuchel.controller.rest;

import at.kuchel.Context;
import at.kuchel.api.LastSyncDateRequest;
import at.kuchel.api.RecipeDetailedResponse;
import at.kuchel.service.rest.RecipeServiceApi;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping(Context.REST_API + "recipes")
public class RecipeControllerApi {
    private static final Logger LOG = getLogger(RecipeControllerApi.class);

    private final RecipeServiceApi recipeService;

    @Autowired
    public RecipeControllerApi(RecipeServiceApi recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<RecipeDetailedResponse> list() {
        LOG.info("Retrieving all recipes via GET");
        return recipeService.getAllRecipes();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<RecipeDetailedResponse> list(@RequestBody LastSyncDateRequest lastSyncDateRequest) {
        LOG.info("Retrieving all recipes via POST with sync date '{}'", lastSyncDateRequest.getLastSyncDate());
        List<RecipeDetailedResponse> recipes = recipeService.getAllRecipes(lastSyncDateRequest);
        LOG.info("Returned '{}' recipes via POST and sync date", recipes.size());
        return recipes;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RecipeDetailedResponse getById(@PathVariable String id) {
        LOG.info("Retrieve recipe with id '{}'", id);
        return recipeService.getRecipeById(id);
    }
}