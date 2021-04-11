package com.groupjn.productservice.controller;

import com.groupjn.productservice.Builder.CategoryClass;
import com.groupjn.productservice.api.command.AddProductCommand;
import com.groupjn.productservice.entity.ProductSummary;
import com.groupjn.productservice.model.Category;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("category")
public class ProductCategoryController {

    @PostMapping("/addCategory")
    public void handle(@RequestBody Category cat) {
        CategoryClass cc = new CategoryClass.CategoryBuilder(cat.name)
                .description(cat.description)
                .build();
    }
}
