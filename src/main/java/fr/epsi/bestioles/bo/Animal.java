package fr.epsi.bestioles.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="animal")
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="color")
    private String color;
    @Column(name="name")
    private String name;
    @Column(name="sex")
    private String sex;

    @ManyToOne
    @JoinColumn(name="species_id")
    private Species species;

    @ManyToMany(mappedBy = "animals", cascade=CascadeType.ALL )
    private Set<Person> persons;

    public Animal() {
    }

    public Animal(String color, String name, String sex, Species species) {
        this.color = color;
        this.name = name;
        this.sex = sex;
        this.species = species;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", species=" + species +
                '}';
    }
}
