package org.example.product_service.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.product_service.domain.Category;
import org.example.product_service.repository.CategoryRepository;
import org.example.product_service.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public Category createCategory(Category category) {
        if (category.getParent() != null &&
                category.getParent().getId() == null) {
            throw new IllegalArgumentException("Parent category of exist");
        }
        return repository.save(category);
    }

    @Override
    public Category getCategory(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    @Override
    public List<Category> getRootCategories() {
        return repository.findAllRootCategories();
    }

    @Override
    public List<Category> getChildren(UUID parentId) {
        return repository.findByParentId(parentId);
    }
}
