package uz.pdp.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.pcmarket.entity.Basket;
import uz.pdp.pcmarket.entity.BasketProduct;
import uz.pdp.pcmarket.payload.BasketProductDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.repository.BasketProductRepo;
import uz.pdp.pcmarket.repository.BasketRepo;

import java.util.List;
import java.util.Optional;

@Service
public class BasketProductService {

    @Autowired
    BasketProductRepo basketProductRepo;

    @Autowired
    BasketRepo basketRepo;

    public List<BasketProduct> allBasketProduct() {
        List<BasketProduct> productList = basketProductRepo.findAll();
        return productList;
    }

    public BasketProduct getBasketProduct(Integer id) {
        Optional<BasketProduct> productOptional = basketProductRepo.findById(id);
        return productOptional.get();
    }

    public Result addBasketProduct(BasketProductDto basketProductDto) {
        BasketProduct basketProduct = new BasketProduct();
        basketProduct.setBasketId(basketProductDto.getBasketId());
        basketProductRepo.save(basketProduct);
        return new Result("Add BasketProduct", true);
    }

    public Result editingBasketProduct(Integer id, BasketProductDto basketProductDto) {
        Optional<BasketProduct> productOptional = basketProductRepo.findById(id);
        if (productOptional.isPresent()) {
            BasketProduct basketProduct = productOptional.get();
            basketProduct.setBasketId(basketProductDto.getBasketId());
            return new Result("Editing basketProduct", true);
        }
        return new Result("Empty", false);
    }

    public Result deletedBasketProduct(Integer id) {
        basketProductRepo.deleteById(id);
        return new Result("BasketProduct", true);
    }

}
