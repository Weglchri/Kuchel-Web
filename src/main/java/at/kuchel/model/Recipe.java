package at.kuchel.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RECIPE")
public class Recipe extends AbstractEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "DURATION")
    @NotNull(message = "Noch keine Dauer angegeben")
    private Long duration;

    @Column(name = "DIFFICULTY")
    @Min(1)
    @Max(5)
    @NotNull(message = "Schwierigkeit muss zwischen 1 und 5 liegen")
    private Long difficulty;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @NotEmpty(message = "Mindestens ein Schritt wird vorausgesetzt")
    @Valid
    private List<Instruction> instructions = new ArrayList<>();

    @Column(name = "NAME", unique = true)
    @Size(min = 5, max = 100, message = "Der Rezeptname muss zwischen 5 und 100 Buchstaben haben")
    private String name;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @NotEmpty(message = "Mindestens eine Zutat wird vorausgesetzt")
    @Valid
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @NotNull
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @NotNull
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

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
        recipeIngredients.forEach(recipeIngredient -> ingredients.add(recipeIngredient.getIngredient()));
        return ingredients;
    }

    public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
        recipeIngredients.add(recipeIngredient);
    }

    public Long getDuration() { return duration; }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Long difficulty) {
        this.difficulty = difficulty;
    }

    public List<Image> getImages() {
        return images;
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        setModifiedDate(creationDate);
        this.creationDate = creationDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
