package at.kuchel.model;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User extends AbstractEntity<Long> {

    @NotBlank
    @Column(name = "USERNAME")
    private String username;

    @Override
    protected Long getId() {
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
