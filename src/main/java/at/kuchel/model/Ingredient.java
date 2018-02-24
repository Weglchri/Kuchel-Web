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

    @NotBlank
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "RECIPE_INGREDIENT", joinColumns = {@JoinColumn(name = "INGREDIENT_ID", nullable = true, updatable = true)}, inverseJoinColumns = {@JoinColumn(name = "RECIPE_ID", nullable = true, updatable = true)})
    private Set<Recipe> recipes = new HashSet<>(0);

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

    public Set<Recipe> getRecipe() {
        return recipes;
    }

    public void setRecipe(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
