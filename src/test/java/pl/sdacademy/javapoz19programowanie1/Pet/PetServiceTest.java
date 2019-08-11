package pl.sdacademy.javapoz19programowanie1.Pet;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PetServiceTest {

    @Test
    public void findAllShouldReturnListOfPets() {
        List<Pet> testPets = Arrays.asList(
                new Pet("pet1", 2, "a", "xyz"),
                new Pet("pet2", 5, "b", "abc")
        );
        PetService petService = new PetService((new InMemoryPetRepository(testPets)));

        List<Pet> actualList = petService.findAll();

        Assert.assertEquals(
                testPets,
                actualList
        );
    }

    @Test
    public void findByBreedShouldReturnFilteredList() {
        PetService petService = new PetService(new InMemoryPetRepository());

        List<Pet> list = petService.findByBreed("Golden Retriever");

        Assert.assertEquals("Lista powinna zawierać 5 elementów",5, list.size());

        Assert.assertTrue("Wszystkie elementy powinnyt mieć wartość Golden Retriever", list.stream()
                .map(pet -> pet.getBreed())
                .allMatch(breed -> breed.equals("Golden Retriever")));
        System.out.println(list);
    }

    @Test
    public void findByLocationShouldReturnFilteredListByLocation() {
        PetService petService = new PetService(new InMemoryPetRepository());

        List<Pet> list = petService.findByLocation("Camas, Pennsylvania");

        Assert.assertEquals("Lista powinna zawierać 5 elementów",5, list.size());

        Assert.assertTrue("Wszystkie elementy powinnyt mieć wartość Camas, Pennsylvania", list.stream()
                .map(pet -> pet.getLocation())
                .allMatch(location -> location.equals("Camas, Pennsylvania")));
        System.out.println(list);
    }

    @Test
    public void sortByAgeShouldReturnSortedList() {
        PetService petService = new PetService(new InMemoryPetRepository());

        List<Pet> pets = petService.sortByAge();

        //tu wstawić asercję listy na zasadzie porównania, czy odpowiednie zwierzaki są na odpowiednim miejscu listy pets
    }

    @Test
    public void groupByBreedShouldReturnMapWithGroupedPets() {
        PetService petService = new PetService(new InMemoryPetRepository());

        Map<String, List<Pet>> map = petService.groupByBreed();

        Assert.assertEquals(3, map.get("Scottish Terrier").size());
        Assert.assertEquals(5, map.get("French Bulldog").size());
        Assert.assertEquals(3, map.get("Boxer").size());
        Assert.assertEquals(5, map.get("Golden Retriever").size());

    }

}
