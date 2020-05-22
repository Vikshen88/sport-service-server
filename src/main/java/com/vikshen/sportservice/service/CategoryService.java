package com.vikshen.sportservice.service;

import com.vikshen.sportservice.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getCategories();

    void save(Category category);


}
