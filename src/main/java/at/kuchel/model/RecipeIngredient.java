package at.kuchel.model;

import javax.persistence.*;

@Entity
@Table(name = "RECIPE_INGREDIENT")
public class RecipeIngredient extends AbstractEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "QUANTITY")
    private String quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPE_ID")
    public Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "INGREDIENT_ID")
    public Ingredient ingredient;

    @Enumerated(EnumType.STRING)
    private Type qualifier;

    public enum Type {
        Stück,
        dag,
        ml;
    }

    public Long getId() {
        return id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Type getQualifier() {
        return qualifier;
    }

    public void setQualifier(Type qualifier) {
        this.qualifier = qualifier;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
