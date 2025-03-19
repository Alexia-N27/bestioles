package fr.epsi.bestioles.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="age")
    private Integer age;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="login")
    private String login;
    @Column(name="mdp")
    private String mdp;
    @Column(columnDefinition = "TINYINT")
    private boolean active;

    @ManyToMany
    @JoinTable(name = "person_role",
        joinColumns = @JoinColumn(name="person_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="person_animals",
        joinColumns = @JoinColumn(name="person_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="animals_id", referencedColumnName = "id")
    )
    private Set<Animal> animals;

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", active=" + active +
                '}';
    }
}
