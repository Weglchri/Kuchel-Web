package at.kuchel.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "RECIPE")
public class Recipe extends AbstractEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "recipe")
    private List<Instruction> instructions;

    @NotBlank
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "recipes")
    private Set<Ingredient> ingredients;

    @Override
    protected Long getId() {
        return id;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
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

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }
}
