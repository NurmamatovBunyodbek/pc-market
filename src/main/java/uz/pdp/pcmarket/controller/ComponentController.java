package uz.pdp.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarket.entity.Component;
import uz.pdp.pcmarket.payload.ComponentDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.service.ComponentService;

import java.util.List;

@RestController
@RequestMapping("/component")
public class ComponentController {


    @Autowired
    ComponentService componentService;

    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @GetMapping
    public List<Component> all() {
        List<Component> components = componentService.allComponent();
        return components;
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @PostMapping
    public Result add(@RequestBody ComponentDto componentDto) {
        Result result = componentService.addComponent(componentDto);
        return result;
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody ComponentDto componentDto) {
        Result result = componentService.editingComponent(id, componentDto);
        return result;
    }
    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = componentService.deletedComponent(id);
        return result;
    }

}
