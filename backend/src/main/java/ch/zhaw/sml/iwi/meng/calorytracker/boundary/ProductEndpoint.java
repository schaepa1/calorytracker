package ch.zhaw.sml.iwi.meng.calorytracker.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.calorytracker.entity.Product;
import ch.zhaw.sml.iwi.meng.calorytracker.entity.ProductRepository;

@RestController
public class ProductEndpoint {
    @Autowired
    private ProductRepository productRepository;

     @RequestMapping(path = "/api/product/get/{user}/{date}", method = RequestMethod.GET, produces = "application/json")
     @PreAuthorize("isAuthenticated() AND hasRole('USER')")
     public List<Product> getProducts(@PathVariable("user") String UserLoginName, @PathVariable("date") String ProductDate) {
        
         return productRepository.findProductByUserandDate(UserLoginName, ProductDate);
     }

     @RequestMapping(path = "/api/product/delete/{id}", method = RequestMethod.DELETE)
     @PreAuthorize("isAuthenticated() AND hasRole('USER')")
     public void deleteProduct(@PathVariable("id") int ProductId) {
        //productRepository.deleteById(ProductId);
     }

}
