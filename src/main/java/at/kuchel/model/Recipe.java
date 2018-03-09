package at.kuchel.model;

import javax.persistence.*;
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
    @Size(min = 1)
    private List<Instruction> instructions = new ArrayList<>();

    @Size(min = 6)
    @Column(name = "NAME", unique = true)
    private String name;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
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
        instruction.setRecipe(this);
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

    public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
        recipeIngredients.add(recipeIngredient);
    }
}
