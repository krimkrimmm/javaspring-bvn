package vn.scrip.buoi9bvn.service;
import vn.scrip.buoi9bvn.model.Product;
import vn.scrip.buoi9bvn.repository.ProductRepository;
import java.util.List;

public class ProductService
{
    public List<Product> getAllProducts() {
        return ProductRepository.getProducts();
    }
}








