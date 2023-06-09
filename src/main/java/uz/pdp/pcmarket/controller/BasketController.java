package uz.pdp.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarket.entity.Basket;
import uz.pdp.pcmarket.payload.BasketDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.service.BasketService;

import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    BasketService basketService;

    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @GetMapping
    public List<Basket> all() {
        List<Basket> basketList = basketService.allBasketList();
        return basketList;
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @GetMapping("/{id}")
    public Basket getId(@PathVariable Integer id) {
        Basket basketId = basketService.getBasketId(id);
        return basketId;
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @PostMapping
    public Result add(@RequestBody BasketDto basketDto) {
        Result result = basketService.addBasket(basketDto);
        return result;
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody BasketDto basketDto) {
        Result result = basketService.editingBasket(id, basketDto);
        return result;
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = basketService.deletedBasket(id);
        return result;
    }

}
