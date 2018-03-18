package at.kuchel.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "IMAGE")
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "MODIFIED_DATE")
    private LocalDate modifiedDate;

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

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
