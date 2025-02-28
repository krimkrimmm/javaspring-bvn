package vn.scrip.buoi9bvn.Productcontroller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.scrip.buoi9bvn.Product;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/products")
class ProductController {
    private final List<Product> products = new ArrayList<>(List.of(

            new Product("1", "iPhone 13", "Apple Smartphone", 999, "Apple"),
            new Product("2", "Galaxy S22", "Samsung Smartphone", 899, "Samsung"),
            new Product("3", "MacBook Pro", "Apple Laptop", 1999, "Apple"),
            new Product("4", "ThinkPad X1", "Lenovo Laptop", 1499, "Lenovo"),
            new Product("5", "Xperia 5 III", "Sony Smartphone", 799, "Sony"),
            new Product("6", "Surface Laptop 4", "Microsoft Laptop", 1299, "Microsoft"),
            new Product("7", "Dell XPS 13", "Dell Laptop", 1399, "Dell"),
            new Product("8", "OnePlus 9 Pro", "OnePlus Smartphone", 729, "OnePlus"),
            new Product("9", "Asus ROG Phone 5", "Gaming Smartphone", 999, "Asus"),

            new Product("10", "HP Spectre x360", "HP Laptop", 1499, "HP")
    ));
    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }
}





