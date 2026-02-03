package org.example.product_service.service;

import org.example.product_service.domain.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    Category createCategory(Category category);

    Category getCategory(UUID id);

    List<Category> getRootCategories();

    List<Category> getChildren(UUID parentId);
}
