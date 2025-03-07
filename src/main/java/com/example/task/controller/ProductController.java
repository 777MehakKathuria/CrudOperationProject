package com.example.task.controller;

import com.example.task.model.Product;
import com.example.task.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/{id}")
  public Optional<Product> getProductById(@PathVariable String id) {
    return productService.getProductById(id);
  }

  @PostMapping("/by-name")
  public Optional<Product> getProductByName(@RequestBody String name) {
    return productService.getProductByName(name);
  }

  // Add a new product
  @PostMapping
  public Product addProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }

  // Update an existing product (Fixed @PutMapping and added path variable)
  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable String id, @RequestBody Product productDetails) {
    return productService.updateProduct(id, productDetails);
  }

  // Patch update an existing product (Fixed @PatchMapping and added path variable)
  @PatchMapping("/{id}")
  public Product updatePatchProduct(@PathVariable String id, @RequestBody Product productDetails) {
    return productService.patchUpdateProduct(id, productDetails);
  }

  // Delete a product
  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable String id) {
    productService.deleteProduct(id);
  }
}
