package at.kuchel.model;

import javax.persistence.*;

@Entity
@Table(name = "IMAGE")
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "DATA")
    private byte[] data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPE_ID")
    public Recipe recipe;

    public byte[] getDate() {
        return data;
    }

    public void setDate(byte[] date) {
        this.data = date;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
