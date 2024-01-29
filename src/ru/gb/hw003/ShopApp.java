package ru.gb.hw003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ShopApp {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        // Инициализация данных
        customers.addAll(Arrays.asList(
                new Customer("Alice", Customer.Gender.FEMALE),
                new Customer("Bob", Customer.Gender.MALE),
                new Customer("Jack", Customer.Gender.MALE)
                // Другие покупатели
        ));

        products.addAll(Arrays.asList(
                new Product("Laptop", 999.99),
                new Product("Smartphone", 499.99),
                new Product("Tablet", 359.99)
                // Другие товары
        ));

        // Примеры совершения покупок
        try {
            orders.add(makePurchase("Alice", "Laptop", 1));
            orders.add(makePurchase("Bob", "Smartphone", 2));
            orders.add(makePurchase("Jack", "Tablet", 4));
            orders.add(makePurchase("Bob", "Smartphone", 7));
            orders.add(makePurchase("Jack", "Smartphone", 9));
            // Другие покупки
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Запись заказов в файл
        try {
            writeOrdersToFile("orders.txt", orders);
        } catch (IOException e) {
            System.err.println("Error writing orders to file: " + e.getMessage());
        }

        // Вывод итогов
        System.out.println("Total purchases: " + orders.size());
        // Здесь добавить код записи в файл
    }
    // Метод для записи заказов в файл
    private static void writeOrdersToFile(String fileName, List<Order> orders) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Order order : orders) {
                writer.write(order.toString());
                writer.newLine();
            }
        }
    }

    public static Order makePurchase(String customerName, String productName, int quantity)
            throws InvalidCustomerException, InvalidProductException, InvalidQuantityException {
        Customer customer = customers.stream()
                .filter(c -> c.getName().equals(customerName))
                .findFirst()
                .orElseThrow(() -> new InvalidCustomerException("Customer not found: " + customerName));

        Product product = products.stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new InvalidProductException("Product not found: " + productName));

        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be positive: " + quantity);
        }

        return new Order(customer, product, quantity);
    }
}
