package at.kuchel.model;


import at.kuchel.constraint.FieldMatch;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "USER")
@FieldMatch(first = "password", second = "confirmPassword", message = "Die Passwörter müssen übereinstimmen!")
public class User extends AbstractEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank (message = "Benutzername darf nicht leer sein!")
    @Column(name = "USERNAME")
    private String username;

    @NotBlank (message = "Passwort darf nicht leer sein!")
    @Column(name = "PASSWORD")
    private String password;

    @NotBlank
    @Transient
    private String confirmPassword;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "MAIL_ADDRESS")
    private String mailAddress;

    @OneToMany(mappedBy = "user")
    private List<Recipe> recipes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Override
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Recipe> getRecipes() {
       return recipes;
    }

    public void setRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
}
