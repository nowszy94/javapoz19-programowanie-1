package pl.sdacademy.javapoz19programowanie1.user;

import org.junit.Assert;
import org.junit.Test;

public class UserServiceWithAddressTest {

    @Test
    public void a() {
        UserService userService = new UserService();
        UserWithAddress userWithAddress = new UserWithAddress("asdf",
                Gender.female,
                "12345",
                12,
                new Address("Poznan", "xyz"));

        int cityLength = userService.getCityLength(userWithAddress);

        Assert.assertEquals(6, cityLength);
    }

    @Test
    public void b() {
        UserService userService = new UserService();
        UserWithAddress userWithAddress = null;

        int cityLength = userService.getCityLength(userWithAddress);

        Assert.assertEquals(0, cityLength);
    }

    @Test
    public void c() {
        UserService userService = new UserService();
        UserWithAddress userWithAddress = new UserWithAddress("asdf",
                Gender.female,
                "12345",
                12,
                null);

        int cityLength = userService.getCityLength(userWithAddress);

        Assert.assertEquals(0, cityLength);
    }

    @Test
    public void d() {
        UserService userService = new UserService();
        UserWithAddress userWithAddress = new UserWithAddress("asdf",
                Gender.female,
                "12345",
                12,
                new Address(null, null));

        int cityLength = userService.getCityLength(userWithAddress);

        Assert.assertEquals(0, cityLength);
    }
}
