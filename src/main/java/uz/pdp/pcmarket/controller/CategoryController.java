package uz.pdp.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarket.entity.Category;
import uz.pdp.pcmarket.payload.CategoryDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> all() {
        List<Category> categories = categoryService.allCategoryList();
        return categories;
    }

    @GetMapping("/{id}")
    public Category getId(@PathVariable Integer id) {
        Category categoryId = categoryService.getCategoryId(id);
        return categoryId;
    }

    @PostMapping
    public Result add(@RequestBody CategoryDto categoryDto) {
        Result result = categoryService.addCategory(categoryDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        Result result = categoryService.editingCategory(id, categoryDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id) {
        Result result = categoryService.deletedCategory(id);
        return result;
    }

}
