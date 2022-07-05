package ch.zhaw.sml.iwi.meng.calorytracker.boundary;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

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
    @RequestMapping(path = "/api/users", method = RequestMethod.PUT)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public void SetUserCalories(Principal principal, @RequestBody User caloriesDemand) {
        User user = userRepository.findById(principal.getName()).get();
        user.setUserWeightGainCalories(caloriesDemand.getUserWeightGainCalories());
        user.setUserWeightLoseCalories(caloriesDemand.getUserWeightLoseCalories());
        user.setUserWeightKeepCalories(caloriesDemand.getUserWeightKeepCalories());
        userRepository.save(user);
    }
    //@RequestMapping(path = "/api/users", method = RequestMethod.GET)
    //@PreAuthorize("isAuthenticated() AND hasRole('USER')")
    //public void GetUserCalories(Principal principal) {
    //    User user = userRepository.findById(principal.getName()).get();
    //    user.setUserWeightGainCalories(caloriesDemand.getUserWeightGainCalories());
    //    user.setUserWeightLoseCalories(caloriesDemand.getUserWeightLoseCalories());
    //    user.setUserWeightKeepCalories(caloriesDemand.getUserWeightKeepCalories());
    //    userRepository.save(user);
    //}

}