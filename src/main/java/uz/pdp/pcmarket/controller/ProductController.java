package uz.pdp.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarket.entity.Product;
import uz.pdp.pcmarket.payload.ProductDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductService productService;

    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','OPERATOR')")
    @GetMapping
    public List<Product> all() {
        List<Product> products = productService.allProductList();
        return products;
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','OPERATOR')")
    @GetMapping("/{id}")
    public Product getId(@PathVariable Integer id) {
        Product productId = productService.getProductId(id);
        return productId;
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','MODERATOR','OPERATOR')")
    @PostMapping
    public Result add(@RequestBody ProductDto productDto) {
        Result result = productService.addProduct(productDto);
        return result;
    }
    @PreAuthorize(value = "hasAnyRole('SUPER_ADMIN','MODERATOR')")
    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        Result result = productService.editingProduct(id, productDto);
        return result;
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = productService.deletedProduct(id);
        return result;
    }
}
