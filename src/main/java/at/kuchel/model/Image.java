package at.kuchel.model;

import javax.persistence.*;

@Entity
@Table(name = "IMAGE")
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "NAME")
    private String name;

    @JoinColumn(name = "DATA")
    @Lob
    private byte[] data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPE_ID")
    public Recipe recipe;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] date) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
