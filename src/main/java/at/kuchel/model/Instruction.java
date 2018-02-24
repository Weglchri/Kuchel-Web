package at.kuchel.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "INSTRUCTION")
public class Instruction extends AbstractEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(name = "INSTRUCTION_DESCRIPTION")
    private String instructionDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPE_ID")
    public Recipe recipe;

    @Override
    public Long getId() {
        return id;
    }

    public String getInstruction() {
        return instructionDescription;
    }

    public void setInstruction(String instruction) {
        this.instructionDescription = instruction;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
