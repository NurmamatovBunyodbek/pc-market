package uz.pdp.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.pcmarket.entity.Component;
import uz.pdp.pcmarket.payload.ComponentDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.repository.ComponentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentService {

    @Autowired
    ComponentRepo componentRepo;

    public List<Component> allComponent() {
        List<Component> componentList = componentRepo.findAll();
        return componentList;
    }

    public Result addComponent(ComponentDto componentDto) {
        Component component = new Component();
        component.setName(componentDto.getName());
        return new Result("Component add", true);
    }

    public Result editingComponent(Integer id, ComponentDto componentDto) {
        Optional<Component> optionalComponent = componentRepo.findById(id);
        if (optionalComponent.isPresent()) {
            Component component = optionalComponent.get();
            component.setName(componentDto.getName());
            return new Result("editing Component", true);
        }
        return new Result("not found", false);
    }

    public Result deletedComponent(Integer id) {
        componentRepo.deleteById(id);
        return new Result("deleted", true);
    }

}
