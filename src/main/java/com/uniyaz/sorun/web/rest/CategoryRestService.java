package com.uniyaz.sorun.web.rest;

import com.uniyaz.sorun.dao.CategoryDao;
import com.uniyaz.sorun.domain.Category;
import com.uniyaz.sorun.web.converter.CategroyConverter;
import com.uniyaz.sorun.web.dto.CategoryDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/category")
public class CategoryRestService {

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categoryList = categoryDao.findAllCategory();

        CategroyConverter categroyConverter = new CategroyConverter();
        List<CategoryDto> categoryDtoList = categroyConverter.convertToCategoryDtoList(categoryList);
        return Response.ok().entity(categoryDtoList).build();
    }

    @GET
    @Path("/findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        CategoryDao categoryDao = new CategoryDao();
        Category category = categoryDao.findAllById(id);

        CategroyConverter categroyConverter = new CategroyConverter();
        CategoryDto categoryDto = categroyConverter.convertToCategoryDto(category);
        return Response.ok().entity(categoryDto).build();
    }

    @POST
    @Path("/findByIdPost")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByIdPost(@FormParam("id") Long id) {
        CategoryDao categoryDao = new CategoryDao();
        Category category = categoryDao.findAllById(id);

        CategroyConverter categroyConverter = new CategroyConverter();
        CategoryDto categoryDto = categroyConverter.convertToCategoryDto(category);
        return Response.ok().entity(categoryDto).build();
    }

    @POST
    @Path("/saveCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveCategory(CategoryDto categoryDto) {

        CategroyConverter categroyConverter = new CategroyConverter();
        Category category = categroyConverter.convertToCategory(categoryDto);

        CategoryDao categoryDao = new CategoryDao();
        category = categoryDao.saveCategory(category);

        categoryDto = categroyConverter.convertToCategoryDto(category);
        return Response.ok().entity(categoryDto).build();
    }
}