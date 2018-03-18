package at.kuchel.mapper;

import at.kuchel.api.*;
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

    @Autowired
    private ImageMapper imageMapper;

    public RecipeOverviewResponse mapToOverview(Recipe recipe) {
        RecipeOverviewResponse recipeResponse = new RecipeOverviewResponse();
        recipeResponse.setId(String.valueOf(recipe.getId()));
        recipeResponse.setName(recipe.getName());
        if (Objects.nonNull(recipe.getUser())) {
            recipeResponse.setUsername(recipe.getUser().getUsername());
        }
        recipeResponse.setDifficulty(String.valueOf(recipe.getDifficulty()));
        recipeResponse.setDuration(String.valueOf(recipe.getDuration()));

        if (!recipe.getImages().isEmpty()) {
            recipeResponse.setImage(imageMapper.mapOverview(recipe.getImages().get(0)));
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

        recipeResponse.setDifficulty(String.valueOf(recipe.getDifficulty()));
        recipeResponse.setDuration(String.valueOf(recipe.getDuration()));

        List<ImageOverviewResponse> imageResponses = new ArrayList<>();
        recipe.getImages().forEach(image -> imageResponses.add(imageMapper.mapOverview(image)));
        recipeResponse.setImages(imageResponses);

        List<InstructionResponse> instructionResponses = new ArrayList<>();
        recipe.getInstructions().forEach(instruction -> instructionResponses.add(instructionMapper.map(instruction)));
        recipeResponse.setInstructions(instructionResponses);

        List<IngredientResponse> ingredientResponses = new ArrayList<>();
        recipe.getRecipeIngredients().forEach(recipeIngredient -> ingredientResponses.add(ingredientMapper.map(recipeIngredient)));
        recipeResponse.setIngredients(ingredientResponses);

        return recipeResponse;
    }
}
