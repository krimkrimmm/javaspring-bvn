package vn.scrip.buoi9bvn.repository;
import vn.scrip.buoi9bvn.model.Product;
import java.util.List;
import java.util.ArrayList;

public class ProductRepository
{
    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("P001", "iPhone 13", "Latest iPhone with A15 chip", 1099, "Apple"));
        products.add(new Product("P002", "Samsung Galaxy S22", "Flagship Samsung phone", 999, "Samsung"));
        products.add(new Product("P003", "MacBook Pro", "M2 chip laptop", 1999, "Apple"));
        products.add(new Product("P004", "Dell XPS 15", "High-end ultrabook", 1499, "Dell"));
        products.add(new Product("P005", "Sony WH-1000XM5", "Noise-canceling headphones", 399, "Sony"));
        return products;
    }

}

