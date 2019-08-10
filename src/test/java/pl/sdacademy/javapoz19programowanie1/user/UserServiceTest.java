package pl.sdacademy.javapoz19programowanie1.user;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UserServiceTest {

    @Test
    public void findByGenderShouldReturnFilteredList() {
        UserService userService = new UserService();

        List<User> list = userService.findByGender(Gender.female);

        Assert.assertEquals("Lista powinna zawierać 3 elementy",3, list.size());

        Assert.assertTrue("Wszystkie elementy powinnyt mieć wartość female", list.stream()
                .map(user -> user.getGender())
                .allMatch(gender -> gender.equals(Gender.female)));

    }

    @Test
    public void mapToNamesShouldReturnStringList() {
        UserService userService = new UserService();

        List<String> names = userService.mapToNames();

        Assert.assertEquals("Powinno być 5 elementów", 5, names.size());

        Assert.assertEquals(Arrays.asList("Bird Ramsey"
                ,"Lillian Burgess"
                ,"Kristie Cole"
                ,"Leonor Cross"
                ,"Marsh Mccall"), names);
    }

    @Test
    public void sortByAgeShouldReturnSortedByAgeListOfUsers() {
        UserService userService = new UserService();

        List<User> users = userService.sortByAge();

        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void sortByBalanceShouldReturnSortedByBalanceListOfUsers() {
        UserService userService = new UserService();

        List<User> users = userService.sortByBalance();

        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void avgBalanceShouldReturnAvgValue() {
        UserService userService = new UserService();
        double avgBalance = userService.avgBalance();

        Assert.assertEquals("Powinna się pojawić wartość 290318.2", 290318.2, avgBalance, 0.1);
    }

    @Test
    public void findWithHighestBalanceShouldReturnUserWithHighestBalance() {
        UserService userService = new UserService();

        User withHighestBalance = userService.findWithHighestBalance();

        Assert.assertEquals(Long.valueOf(394645), withHighestBalance.getBalance());
    }
}
