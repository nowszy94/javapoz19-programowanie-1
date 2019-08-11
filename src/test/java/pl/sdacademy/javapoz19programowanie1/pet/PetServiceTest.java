package pl.sdacademy.javapoz19programowanie1.pet;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PetServiceTest {

    @Test
    public void findAllShouldReturnListOfPets() {
        // given
        List<Pet> testPets = Arrays.asList(
                new Pet("pet-1", 2, "a", "xyz"),
                new Pet("pet-2", 5, "b", "abc")
        );
        PetService petService = new PetService(new InMemoryPetRepository(testPets));

        // when
        List<Pet> actualList = petService.findAll();

        // then
        Assert.assertEquals(
                testPets,
                actualList
        );
    }

    @Test
    public void findByBreedShouldReturnListOfPetsOfBreed() {
        List<Pet> testPets = Arrays.asList(
                new Pet("pet-1", 2, "a", "xyz"),
                new Pet("pet-2", 5, "b", "abc")
        );
        PetService petService = new PetService(new InMemoryPetRepository(testPets));

        // when
        List<Pet> result = petService.findByBreed("a");

        // then
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(new Pet("pet-1", 2, "a", "xyz"), result.get(0));
    }

    @Test
    public void findByLocationShouldReturnListOfPetsOfLocation() {
        List<Pet> testPets = Arrays.asList(
                new Pet("pet-1", 2, "a", "xyz"),
                new Pet("pet-2", 5, "b", "abc")
        );
        PetService petService = new PetService(new InMemoryPetRepository(testPets));

        // when
        List<Pet> result = petService.findByLocation("xyz");

        // then
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(new Pet("pet-1", 2, "a", "xyz"), result.get(0));
    }

}
