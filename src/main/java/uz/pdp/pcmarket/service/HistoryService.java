package uz.pdp.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.pcmarket.entity.History;
import uz.pdp.pcmarket.entity.Orders;
import uz.pdp.pcmarket.payload.HistoryDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.repository.HistoryRepo;
import uz.pdp.pcmarket.repository.OrdersRepo;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService {

    @Autowired
    HistoryRepo historyRepo;
    @Autowired
    OrdersRepo ordersRepo;

    public List<History> allHistoryList() {
        List<History> historyList = historyRepo.findAll();
        return historyList;
    }

    public History getHistoryId(Integer id) {
        Optional<History> optionalHistory = historyRepo.findById(id);
        return optionalHistory.get();
    }

    public Result addHistory(HistoryDto historyDto) {
        History history = new History();
        Optional<Orders> optionalOrders = ordersRepo.findById(historyDto.getOrderId());
        history.setOrderId(optionalOrders.get());
        return new Result("Added", true);
    }

    public Result editHistory(Integer id, HistoryDto historyDto) {
        Optional<History> byId = historyRepo.findById(id);
        if (byId.isPresent()) {
            History history = byId.get();
            Optional<Orders> optionalOrders = ordersRepo.findById(historyDto.getOrderId());
            history.setOrderId(optionalOrders.get());
            return new Result("Editing", true);
        }
        return new Result("Not fount", false);
    }

    public Result deletedId(Integer id) {
        historyRepo.deleteById(id);
        return new Result("Deleted", true);
    }


}
