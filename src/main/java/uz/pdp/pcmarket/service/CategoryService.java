package uz.pdp.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.pcmarket.entity.Category;
import uz.pdp.pcmarket.payload.CategoryDto;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.repository.CategoryRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> allCategoryList() {
        List<Category> categoryList = categoryRepo.findAll();
        return categoryList;
    }

    public Category getCategoryId(Integer id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        return optionalCategory.get();
    }

    public Result addCategory(@RequestBody CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        return new Result("Add Category", true);
    }

    public Result editingCategory(Integer id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setName(categoryDto.getName());
            return new Result("Editing Category", true);
        }
        return new Result("Category not found", false);
    }

    public Result deletedCategory(Integer id) {
        categoryRepo.deleteById(id);
        return new Result("deleted ", true);
    }

}
