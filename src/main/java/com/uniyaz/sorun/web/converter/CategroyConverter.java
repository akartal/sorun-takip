package com.uniyaz.sorun.web.converter;

import com.uniyaz.sorun.domain.Category;
import com.uniyaz.sorun.web.dto.CategoryDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKARTAL on 27.12.2019.
 */
public class CategroyConverter {

    public CategoryDto convertToCategoryDto(Category category) {

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    public List<CategoryDto> convertToCategoryDtoList(List<Category> categoryList) {

        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryDto categoryDto = convertToCategoryDto(category);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    public Category convertToCategory(CategoryDto categoryDto) {

        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        return category;
    }
}
