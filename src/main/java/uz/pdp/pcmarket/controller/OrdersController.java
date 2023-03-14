package uz.pdp.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarket.entity.Orders;
import uz.pdp.pcmarket.payload.OrdersDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.service.OrdersService;

import javax.management.relation.RelationSupport;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @GetMapping
    public List<Orders> all() {
        List<Orders> ordersList = ordersService.allOrdersList();
        return ordersList;
    }

    @PostMapping
    public Result add(@RequestBody OrdersDto ordersDto) {
        Result result = ordersService.addOrders(ordersDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody OrdersDto ordersDto) {
        Result result = ordersService.editOrders(id, ordersDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = ordersService.deletedOrders(id);
        return result;
    }
}
