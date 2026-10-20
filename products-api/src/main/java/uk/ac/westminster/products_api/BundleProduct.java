package uk.ac.westminster.products_api;

import java.util.ArrayList;
import java.util.List;

// A BundleProduct IS-A Product, but it also HAS-A list of Products.
// Discuss in the comment below whether inheritance is the best design:
// a bundle is a product sold as one item, but its contents are other products.

//Why is this code using both extends and List<Product>?
//- extends Product means BundleProduct inherits shared fields such as id, name, and price.
//- List<Product> items means it has a collection of products inside it.

public class BundleProduct extends Product {

    private List<Product> items = new ArrayList<>();

    public BundleProduct() {
    }

    public BundleProduct(Long id, String name, double price,
                         List<Product> items) {
        super(id, name, price);
        this.items = items;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }
}

