package ch.zhaw.sml.iwi.meng.calorytracker.boundary;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import ch.zhaw.sml.iwi.meng.calorytracker.controller.ProductController;
import ch.zhaw.sml.iwi.meng.calorytracker.entity.Product;

@RestController
public class ProductEndpointTest {

    @Autowired
    private ProductController productController;

    @RequestMapping(path = "/api/product/{date}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public List<Product> products(Principal principal, @PathVariable("date") String productDate) {
        return productController.listAllProducts(principal.getName(), productDate);       
    }
}