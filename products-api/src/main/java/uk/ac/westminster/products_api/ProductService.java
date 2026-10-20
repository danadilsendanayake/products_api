package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService() {
            products.add(new DigitalProduct(
                    nextId++, "Ebook", 19.99,
                    "https://example.com/Ebook", 25.5
            ));

            products.add(new PhysicalProduct(
                    nextId++, "Keyboard", 79.99,
                    70, "45 x 15 x 4 cm"
            ));
        }

    public List<Product> getAllProducts() {
        return products;
    }
    public Product addProduct(Product product) {
        product.setId(nextId++); // use the value, then add one
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
}
