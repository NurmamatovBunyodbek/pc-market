package uz.pdp.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.pcmarket.entity.Category;
import uz.pdp.pcmarket.entity.Product;
import uz.pdp.pcmarket.payload.ProductDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.repository.CategoryRepo;
import uz.pdp.pcmarket.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;

    public List<Product> allProductList() {
        List<Product> productList = productRepo.findAll();
        return productList;
    }

    public Product getProductId(Integer id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        return optionalProduct.get();
    }

    public Result addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        product.setCategoryId(optionalCategory.get());
        productRepo.save(product);
        return new Result("Product added", true);
    }

    public Result editingProduct(Integer id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            Optional<Category> categoryOptional = categoryRepo.findById(productDto.getCategoryId());
            product.setCategoryId(categoryOptional.get());
            return new Result("Product Editing ", true);
        }
        return new Result("Product not found", false);
    }

    public Result deletedProduct(Integer id) {
        productRepo.deleteById(id);
        return new Result("Deleted Product", true);
    }

}
