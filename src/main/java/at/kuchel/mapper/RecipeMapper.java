package at.kuchel.mapper;

import at.kuchel.api.IngredientResponse;
import at.kuchel.api.InstructionResponse;
import at.kuchel.api.RecipeDetailedResponse;
import at.kuchel.api.RecipeOverviewResponse;
import at.kuchel.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RecipeMapper {

    @Autowired
    private InstructionMapper instructionMapper;

    @Autowired
    private IngredientMapper ingredientMapper;

    public RecipeOverviewResponse mapToOverview(Recipe recipe) {
        RecipeOverviewResponse recipeResponse = new RecipeOverviewResponse();
        recipeResponse.setId(String.valueOf(recipe.getId()));
        recipeResponse.setName(recipe.getName());
        if (Objects.nonNull(recipe.getUser())) {
            recipeResponse.setUsername(recipe.getUser().getUsername());
        }
        return recipeResponse;
    }

    public RecipeDetailedResponse mapToDetail(Recipe recipe) {
        RecipeDetailedResponse recipeResponse = new RecipeDetailedResponse();
        recipeResponse.setId(String.valueOf(recipe.getId()));
        recipeResponse.setName(recipe.getName());
        if (Objects.nonNull(recipe.getUser())) {
            recipeResponse.setUsername(recipe.getUser().getUsername());
        }
        List<InstructionResponse> instructionResponses = new ArrayList<>();
        recipe.getInstructions().forEach(instruction -> instructionResponses.add(instructionMapper.map(instruction)));
        recipeResponse.setInstructionResponses(instructionResponses);

        List<IngredientResponse> ingredientResponses = new ArrayList<>();
        recipe.getRecipeIngredients().forEach(recipeIngredient -> ingredientResponses.add(ingredientMapper.map(recipeIngredient)));
        recipeResponse.setIngredientResponses(ingredientResponses);

        return recipeResponse;
    }
}
