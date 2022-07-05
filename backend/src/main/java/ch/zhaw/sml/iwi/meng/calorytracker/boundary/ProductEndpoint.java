package ch.zhaw.sml.iwi.meng.calorytracker.boundary;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.calorytracker.entity.Product;
import ch.zhaw.sml.iwi.meng.calorytracker.entity.ProductRepository;
import ch.zhaw.sml.iwi.meng.calorytracker.entity.UserRepository;

@RestController
public class ProductEndpoint {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/api/product/{date}", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public List<Product> getProductsbyDate(@PathVariable("date") String ProductDate, Principal principal) 
    {
        return productRepository.findProductByUserandDate(principal.getName(), ProductDate);
    }

    @RequestMapping(path = "/api/product/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public void deleteProduct(@PathVariable("id") int ProductId) 
    {
        productRepository.deleteById(ProductId);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/api/product")
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public void createProduct(Principal principal, @RequestBody Product product) {
        product.setUser(userRepository.getById(principal.getName()));
        productRepository.save(product);
        
    }

}
