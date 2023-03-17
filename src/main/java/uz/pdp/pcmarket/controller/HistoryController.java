package uz.pdp.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @GetMapping
    public List<History> all() {
        List<History> historyList = historyService.allHistoryList();
        return historyList;
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @PostMapping
    public Result add(@RequestBody HistoryDto historyDto) {
        Result result = historyService.addHistory(historyDto);
        return result;
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody HistoryDto historyDto) {
        Result result = historyService.editHistory(id, historyDto);
        return result;
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = historyService.deletedId(id);
        return result;
    }

}
