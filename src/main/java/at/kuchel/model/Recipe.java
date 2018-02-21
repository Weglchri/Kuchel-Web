package at.kuchel.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "RECIPE")
public class Recipe extends AbstractEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    @NotBlank
    @Column(name = "INSTRUCTION")
    private String instruction;

    @Override
    protected Long getId() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
