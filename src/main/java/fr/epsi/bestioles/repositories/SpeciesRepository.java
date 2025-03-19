package fr.epsi.bestioles.repositories;

import fr.epsi.bestioles.bo.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
}
