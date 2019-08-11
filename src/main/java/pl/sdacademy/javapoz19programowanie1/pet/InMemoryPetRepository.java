package pl.sdacademy.javapoz19programowanie1.pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryPetRepository implements PetRepository {
    private List<Pet> pets;

    InMemoryPetRepository(List<Pet> pets) {
        this.pets = pets;
    }

    public InMemoryPetRepository() {
        this.init();
    }

    private void init() {
        this.pets = Arrays.asList(
                new Pet("Frieda", 3, "Scottish Terrier", "Lisco, Alabama"),
                new Pet("Gina", 3, "Scottish Terrier", "Camas, Pennsylvania"),
                new Pet("Collins", 4, "French Bulldog", "Lisco, Alabama"),
                new Pet("Melissa", 2, "Boxer", "Camas, Pennsylvania"),
                new Pet("Jeanine", 5, "French Bulldog", "Lisco, Alabama"),
                new Pet("Elvia", 3, "French Bulldog", "Innsbrook, Illinois"),
                new Pet("Latisha", 6, "Golden Retriever", "Camas, Pennsylvania"),
                new Pet("Coleman", 3, "Golden Retriever", "Jacksonwald, Palau"),
                new Pet("Nichole", 2, "French Bulldog", "Lisco, Alabama"),
                new Pet("Fran", 7, "Boxer", "Camas, Pennsylvania"),
                new Pet("Leonor", 2, "Boxer", "Tyhee, Indiana"),
                new Pet("Dean", 3, "Scottish Terrier", "Lisco, Alabama"),
                new Pet("Stevenson", 3, "French Bulldog", "Camas, Pennsylvania"),
                new Pet("Kristina", 4, "Golden Retriever", "Tyhee, Indiana"),
                new Pet("Ethel", 9, "Golden Retriever", "Lisco, Alabama"),
                new Pet("Terry", 2, "Golden Retriever", "Tyhee, Indiana")
        );
    }

    @Override
    public List<Pet> findAll() {
        return new ArrayList<>(pets);
    }

    @Override
    public List<Pet> findByBreed(String breed) {
        return pets.stream()
                .filter(pet -> pet.getBreed().equals(breed))
                .collect(Collectors.toList());
    }

    @Override
    public List<Pet> findByLocation(String location) {
        return pets.stream()
                .filter(pet -> pet.getLocation().equals(location))
                .collect(Collectors.toList());
    }
}
