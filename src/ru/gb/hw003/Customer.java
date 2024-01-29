package ru.gb.hw003;

public class Customer {
    private String name;
    private Gender gender;

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    // Конструктор, геттеры и сеттеры
    public Customer(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
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
}

