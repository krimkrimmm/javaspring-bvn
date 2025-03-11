package vn.scrip.buoi9bvn.controller;
import vn.scrip.buoi9bvn.model.Product;
import vn.scrip.buoi9bvn.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService = new ProductService();
    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

}

