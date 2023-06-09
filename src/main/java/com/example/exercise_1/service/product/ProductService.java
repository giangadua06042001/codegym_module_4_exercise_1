package com.example.exercise_1.service.product;

import com.example.exercise_1.model.Product;
import com.example.exercise_1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Iterable<Product> fillAll() {
      return   productRepository.findAll();
    }

    @Override
    public Optional<Product> fillById(Long id) {
        return  productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
   productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }
    @Override
    public List<Product> getListProductByName(String name){
      return  productRepository.findAllByNameContaining(name);
    }


}
