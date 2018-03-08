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

    @OneToMany(mappedBy = "recipe",  cascade={CascadeType.ALL})
    @Size(min = 1)
    private List<Instruction> instructions = new ArrayList<>();

    @Size(min = 6)
    @Column(name = "NAME",unique = true)
    private String name;

    @Size(min = 2)
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "RECIPE_INGREDIENT", joinColumns = {@JoinColumn(name = "RECIPE_ID", nullable = true, updatable = true)}, inverseJoinColumns = {@JoinColumn(name = "INGREDIENT_ID", nullable = true, updatable = true)})
    private List<Ingredient> ingredients = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
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

    public void addInstruction(Instruction instructions) {
        this.instructions.add(instructions);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
