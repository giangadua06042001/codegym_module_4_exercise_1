package com.example.exercise_1.service.product;

import com.example.exercise_1.model.Product;
import com.example.exercise_1.service.IGeneralService;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {

    public List<Product> getListProductByName(String name);

}
