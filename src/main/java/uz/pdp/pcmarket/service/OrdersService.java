package uz.pdp.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetSupportingSqlParameter;
import org.springframework.stereotype.Service;
import uz.pdp.pcmarket.entity.Orders;
import uz.pdp.pcmarket.payload.OrdersDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.repository.OrdersRepo;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {


    @Autowired
    OrdersRepo ordersRepo;

    public List<Orders> allOrdersList() {
        List<Orders> ordersList = ordersRepo.findAll();
        return ordersList;
    }

    public Result addOrders(OrdersDto ordersDto) {
        Orders orders = new Orders();
        orders.setCanceled(ordersDto.isCanceled());
        orders.setClaimed(ordersDto.isClaimed());
        orders.setBasketId(ordersDto.getBasketId());
        ordersRepo.save(orders);
        return new Result("Added", true);
    }

    public Result editOrders(Integer id, OrdersDto ordersDto) {
        Optional<Orders> optionalOrders = ordersRepo.findById(id);
        if (optionalOrders.isPresent()) {
            Orders orders = optionalOrders.get();
            orders.setBasketId(ordersDto.getBasketId());
            orders.setCanceled(ordersDto.isCanceled());
            orders.setClaimed(ordersDto.isClaimed());
            return new Result("Editing ", true);
        }
        return new Result("Not found", false);
    }

    public Result deletedOrders(Integer id) {
        ordersRepo.deleteById(id);
        return new Result("deleted", true);
    }


}
