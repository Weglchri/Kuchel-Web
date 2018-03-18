package at.kuchel.api;

import lombok.Data;

@Data
public class RecipeOverviewResponse {
    private String id;
    private String username;
    private String name;
    private String duration;
    private String difficulty;
}
