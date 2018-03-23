package at.kuchel.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "INSTRUCTION")
public class Instruction extends AbstractEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "INSTRUCTION_DESCRIPTION")
    @Size(min = 5, max = 500, message = "Beschreibe kurz den Vorgang")
    private String description;

    @Column(name = "STEP")
    private String step;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPE_ID")
    public Recipe recipe;

    @Override
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
