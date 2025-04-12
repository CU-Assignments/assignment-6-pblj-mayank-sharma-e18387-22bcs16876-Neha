// Hard Level 🌳
// Task: Write a Java program to process a large dataset of products using
// streams. Implement the following operations:

// Group products by category.
// Find the most expensive product in each category.
// Calculate the average price of all products.

import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}

public class ProductProcessing {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1000),
                new Product("Smartphone", "Electronics", 700),
                new Product("Shirt", "Apparel", 50),
                new Product("Pants", "Apparel", 40),
                new Product("TV", "Electronics", 1200),
                new Product("Jacket", "Apparel", 100));

        // 1. Group products by category
        System.out.println("Products grouped by category:");
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        // 2. Find the most expensive product in each category
        System.out.println("\nMost expensive product in each category:");
        Map<String, Product> mostExpensiveProduct = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)),
                                Optional::get)));
        mostExpensiveProduct.forEach((category, product) -> {
            System.out.println(category + ": " + product);
        });

        // 3. Calculate the average price of all products
        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}
