package ch.zhaw.sml.iwi.meng.calorytracker.boundary;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.calorytracker.entity.User;
import ch.zhaw.sml.iwi.meng.calorytracker.entity.UserRepository;

@RestController
public class UserEndpoint {

    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping(path = "/api/me", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public String me(Principal principal) {
    
        return "{\"user\": \"" + principal.getName() + "\"} ";
    }
    @RequestMapping(path = "/api/users", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}