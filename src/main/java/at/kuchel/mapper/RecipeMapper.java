package at.kuchel.mapper;

import at.kuchel.api.RecipeResponse;
import at.kuchel.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RecipeMapper {

    public RecipeResponse map(Recipe recipe) {
        RecipeResponse recipeResponse = new RecipeResponse();
        recipeResponse.setId(String.valueOf(recipe.getId()));
        recipeResponse.setName(recipe.getName());
        if (Objects.nonNull(recipe.getUser())) {
            recipeResponse.setUsername(recipe.getUser().getUsername());
        }
        return recipeResponse;
    }
}
