package fr.epsi.bestioles.repositories;

import fr.epsi.bestioles.bo.Animal;
import fr.epsi.bestioles.bo.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findBySpecies_Id(Integer speciesId);

    List<Animal> findByColor(String color);
}
