package uz.pdp.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarket.entity.History;
import uz.pdp.pcmarket.payload.HistoryDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.service.HistoryService;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @GetMapping
    public List<History> all() {
        List<History> historyList = historyService.allHistoryList();
        return historyList;
    }

    @PostMapping
    public Result add(@RequestBody HistoryDto historyDto) {
        Result result = historyService.addHistory(historyDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody HistoryDto historyDto) {
        Result result = historyService.editHistory(id, historyDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = historyService.deletedId(id);
        return result;
    }

}
