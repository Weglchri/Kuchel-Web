package at.kuchel.controller.rest;

import at.kuchel.Context;
import at.kuchel.api.RecipeResponse;
import at.kuchel.service.rest.RecipeServiceApi;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping(Context.REST_API + "/recipes")
public class RecipeControllerApi {
    private static final Logger LOG = getLogger(RecipeControllerApi.class);

    @Autowired
    private RecipeServiceApi recipeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<RecipeResponse> list() {
        LOG.info("Retrieving all recipes");
        return recipeService.getAllRecipes();
    }
}