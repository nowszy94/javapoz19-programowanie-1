package pl.sdacademy.javapoz19programowanie1.user;

public class User {

    private String name;
    private Gender gender;
    private Long balance;
    private int age;

    public User(String name, Gender gender, String balance, int age) {
        this.name = name;
        this.gender = gender;
        this.balance = Long.valueOf(
                balance.replace("$", "")
                        .replace(".", "")
                        .replace(",", "")
        );
        this.age = age;
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
