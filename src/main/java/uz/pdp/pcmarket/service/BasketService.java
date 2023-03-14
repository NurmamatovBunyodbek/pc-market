package uz.pdp.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.pcmarket.entity.Basket;
import uz.pdp.pcmarket.entity.User;
import uz.pdp.pcmarket.payload.BasketDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.repository.BasketRepo;
import uz.pdp.pcmarket.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class BasketService {

    @Autowired
    BasketRepo basketRepo;
    @Autowired
    UserRepo userRepo;

    public List<Basket> allBasketList() {
        List<Basket> basketList = basketRepo.findAll();
        return basketList;
    }

    public Basket getBasketId(Integer id) {
        Optional<Basket> optionalBasket = basketRepo.findById(id);
        return optionalBasket.get();
    }

    public Result addBasket(BasketDto basketDto) {
        Basket basket = new Basket();
        Optional<User> optionalUser = userRepo.findById(basketDto.getUser());
        basket.setUser(optionalUser.get());
        basket.setActive(basketDto.isActive());
        basketRepo.save(basket);
        return new Result("Basket added", true);
    }

    public Result editingBasket(Integer id, BasketDto basketDto) {
        Optional<Basket> optionalBasket = basketRepo.findById(id);
        if (optionalBasket.isPresent()) {
            Basket basket = optionalBasket.get();
            Optional<User> userOptional = userRepo.findById(basketDto.getUser());
            basket.setUser(userOptional.get());
            basket.setActive(basketDto.isActive());
            basketRepo.save(basket);
            return new Result("Editing Basket", true);
        }
        return new Result("Basket empty", false);
    }

    public Result deletedBasket(Integer id) {
        basketRepo.deleteById(id);
        return new Result("Basket deleted", true);
    }

}
