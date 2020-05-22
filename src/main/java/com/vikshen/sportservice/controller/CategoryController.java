package com.vikshen.sportservice.controller;

import com.vikshen.sportservice.entity.Category;
import com.vikshen.sportservice.exception.NotFoundException;
import com.vikshen.sportservice.repository.CategoryRepository;
import com.vikshen.sportservice.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")

    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("/saveCategory")
    public Category save(){
        Category category = new Category();

        categoryService.save(category);

        return category;
    }

}
