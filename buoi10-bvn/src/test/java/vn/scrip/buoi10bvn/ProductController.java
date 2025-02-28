package vn.scrip.buoi10bvn;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
class ProductService {
    private final List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("1", "iPhone 13", "Apple smartphone", 1000, "Apple"),

            new Product("2", "Samsung Galaxy S21", "Samsung smartphone", 900, "Samsung"),
            new Product("3", "MacBook Pro", "Apple laptop", 2000, "Apple"),
            new Product("4", "Dell XPS 15", "Dell laptop", 1500, "Dell")
    ));

    public Optional<Product> getProductById(String id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
    public List<Product> getProductsByNamePrefix(String prefix)
    {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().startsWith(prefix.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Product> getProductsByPriceRange(int min, int max) {
        return products.stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByBrand(String brand) {
        return products.stream()
                .filter(p -> p.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }
    public Optional<Product> getMaxPriceProductByBrand(String brand) {
        return products.stream()
                .filter(p -> p.getBrand().equalsIgnoreCase(brand))
                .max(Comparator.comparingInt(Product::getPrice));
    }
}

@RestController
@RequestMapping("/products")
class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/name-starts/{prefix}")
    public List<Product> getProductsByNamePrefix(@PathVariable String prefix)
    {
        return productService.getProductsByNamePrefix(prefix);
    }










    @GetMapping("/price/{min}/{max}")
    public List<Product> getProductsByPriceRange(@PathVariable int min, @PathVariable int max) {
        return productService.getProductsByPriceRange(min, max);
    }
    @GetMapping("/brand/{brand}")
    public List<Product> getProductsByBrand(@PathVariable String brand) {
        return productService.getProductsByBrand(brand);
    }
    @GetMapping("/brand/{brand}/max-price")
    public ResponseEntity<Product> getMaxPriceProductByBrand(@PathVariable String brand) {
        return productService.getMaxPriceProductByBrand(brand)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

