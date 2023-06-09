package com.example.exercise_1.controller;

import com.example.exercise_1.model.Product;
import com.example.exercise_1.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller

public class ProductController {
    @Autowired
    private IProductService iProductService;


    @GetMapping("/create")
    public ModelAndView formCreate(){
        ModelAndView modelAndView=new ModelAndView("product/formCreate");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createProduct(@ModelAttribute("product") Product product){
        iProductService.save(product);
        ModelAndView modelAndView=new ModelAndView("product/formCreate");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message","Add new product created successfully");
        return modelAndView;
    }
    @GetMapping("/list")
    public ModelAndView listProduct(){
        ModelAndView modelAndView=new ModelAndView("product/listProduct");
        modelAndView.addObject("products",iProductService.fillAll());
//        Product searchProduct = new Product();
//        modelAndView.addObject("searchProduct",searchProduct);
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView formDelete(@PathVariable Long id){
        Optional<Product>product=iProductService.fillById(id);
        if(product.isPresent()){
            ModelAndView modelAndView=new ModelAndView("product/delete");
            modelAndView.addObject("products",product.get());
            return modelAndView;
        }
        else {
            return new ModelAndView("error.404");
        }
    }
    @PostMapping("/delete")
    public  String delete(@ModelAttribute("products") Product product){
        iProductService.remove(product.getId());
        return "redirect:/list";

    }
    @GetMapping("{id}/edit")
    public  ModelAndView formEdit(@PathVariable Long id){
        Optional<Product> product= iProductService.fillById(id);
        ModelAndView modelAndView=new ModelAndView("product/edit");
      modelAndView.addObject("product",product.orElse(null));
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView editProduct(@ModelAttribute("product") Product product){
        iProductService.save(product);
        ModelAndView modelAndView=new ModelAndView("/product/edit");
        modelAndView.addObject("product",product);
        modelAndView.addObject("message","Product updated successfully");
        return modelAndView;
    }
    @GetMapping("{id}/view")
    public ModelAndView views(@PathVariable Long id){
        Optional<Product>product=iProductService.fillById(id);
        ModelAndView modelAndView=new ModelAndView("/product/view");
        modelAndView.addObject("product",product.orElse(null));
        return modelAndView;
    }
    @GetMapping("/search")
    public  ModelAndView  search(@RequestParam("s") String name){
        List<Product> products = iProductService.getListProductByName(name);
        ModelAndView modelAndView=new ModelAndView("/product/listProduct");
        modelAndView.addObject("products",products);
//        Product searchProduct = new Product();
//        modelAndView.addObject("searchProduct",searchProduct);
        return modelAndView;
    }
}
