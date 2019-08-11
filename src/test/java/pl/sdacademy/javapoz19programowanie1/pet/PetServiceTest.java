package pl.sdacademy.javapoz19programowanie1.pet;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @Test
    public void sortByAgeShouldReturnSortedList() {
        List<Pet> testPets = Arrays.asList(
                new Pet("pet-1", 7, "a", "xyz"),
                new Pet("pet-2", 2, "b", "abc"),
                new Pet("pet-3", 5, "c", "def")
        );
        PetService petService = new PetService(new InMemoryPetRepository(testPets));

        List<Pet> pets = petService.sortByAge();

        Assert.assertEquals(pets.get(0), testPets.get(1));
        Assert.assertEquals(pets.get(1), testPets.get(2));
        Assert.assertEquals(pets.get(2), testPets.get(0));
    }

    @Test
    public void groupByBreedShouldReturnMapWithGroupedPets() {
        PetService petService = new PetService(new InMemoryPetRepository());

        Map<String, List<Pet>> map = petService.groupByBreed();

        // then
        Assert.assertEquals(map.get("Scottish Terrier").size(), 3);
        Assert.assertEquals(map.get("French Bulldog").size(), 5);
        Assert.assertEquals(map.get("Boxer").size(), 3);
        Assert.assertEquals(map.get("Golden Retriever").size(), 5);
    }

}
