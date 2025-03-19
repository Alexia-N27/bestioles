package fr.epsi.bestioles;

import fr.epsi.bestioles.bo.Animal;
import fr.epsi.bestioles.bo.Species;
import fr.epsi.bestioles.repositories.AnimalRepository;
import fr.epsi.bestioles.repositories.PersonRepository;
import fr.epsi.bestioles.repositories.RoleRepository;
import fr.epsi.bestioles.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BestiolesApplication implements CommandLineRunner {


    private PersonRepository personRepository;
    private AnimalRepository animalRepository;
    private RoleRepository roleRepository;
    private SpeciesRepository speciesRepository;

    @Autowired
    public BestiolesApplication(PersonRepository personRepository, AnimalRepository animalRepository, RoleRepository roleRepository, SpeciesRepository speciesRepository) {
        this.personRepository = personRepository;
        this.animalRepository = animalRepository;
        this.roleRepository = roleRepository;
        this.speciesRepository = speciesRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BestiolesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Toutes les Person : " + this.personRepository.findAll());
        System.out.println("Touts les Animaux : " + this.animalRepository.findAll());

        Species species = new Species("requin tigre", "Galeocerdo cuvier");
        Animal animal = new Animal("Gris", "Tigrou", "male", species);

        speciesRepository.save(species);
        animalRepository.save(animal);


        // Recherche d'un Animal par son ID
        animalRepository.findById(1).ifPresent(animalFound -> {
            System.out.println("Animal trouvé : " + animalFound);
        });

        // Suppression d'un Animal par son ID
        animalRepository.deleteById(1);
        System.out.println("Nombre d'animaux après suppression : " + animalRepository.count());

        // Vérifier si l'animal a bien été supprimé
        animalRepository.findById(1).ifPresentOrElse(
                animalFound -> System.out.println("Animal toujours présent : " + animalFound),
                () -> System.out.println("Animal avec ID 1 a bien été supprimé.")
        );

        System.out.println("FIND FIRST SPECIES : " + this.speciesRepository.findFirstByCommonName("chat"));
        System.out.println("FIND LIST SPECIES : " + this.speciesRepository.findByLatinNameIgnoreCase("Felis silvestris catus"));
        System.out.println("FIND LIST PERSON : " + this.personRepository.findByFirstnameOrLastname("Henri", "Lamarque"));
        System.out.println("FIND AGE SUP : " + this.personRepository.findByAgeGreaterThanEqual(18));
        System.out.println("FIND ANIMAL BY SPECIES : " + this.animalRepository.findBySpecies_Id(4));
        System.out.println("FIND ANIMAL BY COLOR : " + this.animalRepository.findByColor("Gris"));
    }
}
