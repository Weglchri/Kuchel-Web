package at.kuchel.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "INGREDIENT")
public class Ingredient extends AbstractEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "ingredient")
    private Set<RecipeIngredient> recipeIngredients = new HashSet<>(0);

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        APPROVED,
        NEW,
        REJECTED
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
