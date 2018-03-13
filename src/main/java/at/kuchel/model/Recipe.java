package at.kuchel.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RECIPE")
public class Recipe extends AbstractEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @NotEmpty(message="Mindestens ein Schritt wird vorausgesetzt")
    @Valid
    private List<Instruction> instructions = new ArrayList<>();

    @Column(name = "NAME", unique = true)
    @Size(min = 5, max = 100)
    private String name;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @NotEmpty(message="Mindestens eine Zutat wird vorausgesetzt")
    @Valid
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void addInstruction(Instruction instruction) {
        instructions.add(instruction);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        recipeIngredients.stream().forEach(recipeIngredient -> ingredients.add(recipeIngredient.getIngredient()));
        return ingredients;
    }

    public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
        recipeIngredients.add(recipeIngredient);
    }
}
