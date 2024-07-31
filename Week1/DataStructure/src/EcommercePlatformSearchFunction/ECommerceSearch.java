/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcommercePlatformSearchFunction;

/**
 *
 * @author Aishwarya
 */
import java.util.Arrays;
import java.util.Scanner;
class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class ECommerceSearch {
    private Product[] products;
    private int productCount;

    public ECommerceSearch(int capacity) {
        products = new Product[capacity];
        productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Product array is full. Cannot add more products.");
        }
    }

    public Product linearSearch(int productId) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductId() == productId) {
                return products[i];
            }
        }
        return null;
    }

    public Product binarySearch(int productId) {
        int left = 0;
        int right = productCount - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == productId) {
                return products[mid];
            }
            if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void sortProducts() {
        Arrays.sort(products, 0, productCount, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));
    }

    public static void main(String[] args) {
        ECommerceSearch ecs = new ECommerceSearch(10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nE-Commerce Platform Search Functionality");
            System.out.println("1. Add Product");
            System.out.println("2. Linear Search Product");
            System.out.println("3. Binary Search Product");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Product Category: ");
                    String category = scanner.nextLine();
                    Product newProduct = new Product(productId, productName, category);
                    ecs.addProduct(newProduct);
                    break;

                case 2:
                    System.out.print("Enter Product ID to search (Linear Search): ");
                    productId = scanner.nextInt();
                    Product foundProductLinear = ecs.linearSearch(productId);
                    if (foundProductLinear != null) {
                        System.out.println("Found Product: " + foundProductLinear);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    ecs.sortProducts();
                    System.out.print("Enter Product ID to search (Binary Search): ");
                    productId = scanner.nextInt();
                    Product foundProductBinary = ecs.binarySearch(productId);
                    if (foundProductBinary != null) {
                        System.out.println("Found Product: " + foundProductBinary);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

