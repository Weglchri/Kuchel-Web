package at.kuchel.model;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USER")
public class User extends AbstractEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(name = "USERNAME")
    private String username;

    @NotBlank
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @Override
    protected Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
