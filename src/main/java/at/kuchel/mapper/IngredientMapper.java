package at.kuchel.mapper;

import at.kuchel.api.IngredientResponse;
import at.kuchel.model.RecipeIngredient;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IngredientMapper {

    public IngredientResponse map(RecipeIngredient recipeIngredient) {
        IngredientResponse ingredientResponse = new IngredientResponse();
        ingredientResponse.setId(recipeIngredient.getId().toString());
        ingredientResponse.setQualifier(recipeIngredient.getQualifier() != null ? recipeIngredient.getQualifier().name() : "");
        ingredientResponse.setQuantity(recipeIngredient.getQuantity());
        if (Objects.nonNull(recipeIngredient.getIngredient())) {
            ingredientResponse.setName(recipeIngredient.getIngredient().getName());
            ingredientResponse.setDescription(recipeIngredient.getIngredient().getDescription());
        }

        return ingredientResponse;
    }
}
