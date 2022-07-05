package ch.zhaw.sml.iwi.meng.calorytracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.sml.iwi.meng.calorytracker.entity.Product;
import ch.zhaw.sml.iwi.meng.calorytracker.entity.ProductRepository;

@Component
public class ProductController {


    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAllProducts(String loginName, String productDate) {
        return productRepository.findAllByUserAndDate(loginName, productDate);
    }
    
}