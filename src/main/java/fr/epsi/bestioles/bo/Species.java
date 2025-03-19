package fr.epsi.bestioles.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="species")
public class Species implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="common_name")
    private String commonName;
    @Column(name="latin_name")
    private String latinName;

    @OneToMany(mappedBy = "species", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animal> animals;

    public Species() {
    }

    public Species(String commonName, String latinName) {
        this.commonName = commonName;
        this.latinName = latinName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String common_name) {
        this.commonName = common_name;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latin_name) {
        this.latinName = latin_name;
    }



    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", common_name='" + commonName + '\'' +
                ", latin_name='" + latinName + '\'' +
                '}';
    }
}
