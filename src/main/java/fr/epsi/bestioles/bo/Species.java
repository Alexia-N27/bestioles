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
    private String common_name;
    @Column(name="latin_name")
    private String latin_name;

    @OneToMany(mappedBy = "species", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animal> animals;

    public Species() {
    }

    public Species(String common_name, String latin_name) {
        this.common_name = common_name;
        this.latin_name = latin_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommon_name() {
        return common_name;
    }

    public void setCommon_name(String common_name) {
        this.common_name = common_name;
    }

    public String getLatin_name() {
        return latin_name;
    }

    public void setLatin_name(String latin_name) {
        this.latin_name = latin_name;
    }



    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", common_name='" + common_name + '\'' +
                ", latin_name='" + latin_name + '\'' +
                '}';
    }
}
