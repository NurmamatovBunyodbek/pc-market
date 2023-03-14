package uz.pdp.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarket.entity.BasketProduct;
import uz.pdp.pcmarket.payload.BasketProductDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.service.BasketProductService;

import java.util.List;

@RestController
@RequestMapping("/basketproduct")
public class BasketProductController {

    @Autowired
    BasketProductService basketProductService;

    @GetMapping
    public List<BasketProduct> all() {
        List<BasketProduct> list = basketProductService.allBasketProduct();
        return list;
    }

    @GetMapping("/{id}")
    public BasketProduct getId(@PathVariable Integer id) {
        BasketProduct product = basketProductService.getBasketProduct(id);
        return product;
    }

    @PostMapping
    public Result add(@RequestBody BasketProductDto basketProductDto) {
        Result result = basketProductService.addBasketProduct(basketProductDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody BasketProductDto basketProductDto) {
        Result result = basketProductService.editingBasketProduct(id, basketProductDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = basketProductService.deletedBasketProduct(id);
        return result;
    }


}
