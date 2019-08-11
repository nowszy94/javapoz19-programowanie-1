package pl.sdacademy.javapoz19programowanie1.pet;

import java.util.List;

public interface PetRepository {
    List<Pet> findAll();

    List<Pet> findByBreed(String breed);

    List<Pet> findByLocation(String location);
}
