package at.kuchel.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "IMAGE")
public class Image extends AbstractEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @JoinColumn(name = "DATA")
    @Lob
    private byte[] data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPE_ID")
    public Recipe recipe;

    @Override
    public Long getId() {
        return id;
    }

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

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
