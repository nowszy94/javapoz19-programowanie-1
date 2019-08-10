package pl.sdacademy.javapoz19programowanie1.user;

public class UserWithAddress {
    private String name;
    private Gender gender;
    private Long balance;
    private int age;
    private Address address;

    public UserWithAddress(String name, Gender gender, String balance, int age, Address address) {
        this.name = name;
        this.gender = gender;
        this.balance = Long.valueOf(
                balance.replace("$", "")
                        .replace(".", "")
                        .replace(",", "")
        );
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", balance=" + balance +
                ", age=" + age +
                '}';
    }
}
