package at.kuchel.api;

import lombok.Data;

import java.util.List;

@Data
public class RecipeDetailedResponse {
    private String id;
    private String username;
    private String name;

    private List<IngredientResponse> ingredients;
    private List<InstructionResponse> instructions;
}