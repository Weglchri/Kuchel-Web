package at.kuchel.api;

import lombok.Data;

@Data
public class IngredientResponse {

    private String id;
    private String name;
    private String description;
    private String quantity;
    private String qualifier;
}
