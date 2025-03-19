package fr.epsi.bestioles.repositories;

import fr.epsi.bestioles.bo.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
