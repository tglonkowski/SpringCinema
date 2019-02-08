package pl.cinemaWeb.SpringCinema.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "{user.name.notempty}")
    private String name;

    @NotEmpty(message = "{user.lastName.notempty}")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "{user.email.notempty}")
    private String email;

    @Length(min = 10)
    @NotEmpty(message = "{user.password.notempty}")
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    private Boolean active;

    public User() {
    }

    public User(@NotEmpty(message = "{user.name.notempty}") String name, @NotEmpty(message = "{user.lastName.notempty}") String lastName, @NotEmpty(message = "{user.email.notempty}") String email, @NotEmpty(message = "{user.password.notempty}") String password, @NotEmpty(message = "{user.role.notempty}") RoleEnum role, Boolean active) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    public User(@Length(min = 10) @NotEmpty(message = "{user.password.notempty}") String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", active=" + active +
                '}';
    }
}
