package ch.zhaw.sml.iwi.meng.calorytracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ch.zhaw.sml.iwi.meng.calorytracker.entity.Product;
import ch.zhaw.sml.iwi.meng.calorytracker.entity.ProductRepository;
import ch.zhaw.sml.iwi.meng.calorytracker.entity.Role;
import ch.zhaw.sml.iwi.meng.calorytracker.entity.RoleRepository;
import ch.zhaw.sml.iwi.meng.calorytracker.entity.User;
import ch.zhaw.sml.iwi.meng.calorytracker.entity.UserRepository;


@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class calorytracker implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(calorytracker.class, args);
        
    }

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    // This is only really relevant for development, where we have different servers for frontend and backend
                    .allowedOrigins("http://localhost:8100")
                    .allowedMethods("GET", "PUT", "POST", "DELETE")
                    // AllowCredentials is necessary, as it sets 'Access-Control-Allow-Credentials'. 
                    // Otherwise Angular's HttpClient will not pass the Cookie back.
                    .allowCredentials(true);
            }
        };
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setLoginName("user1");
        user1.setPasswordHash(new BCryptPasswordEncoder().encode("user1"));
        user1.setUserWeightgaincalories(4000);
        user1.setUserWeightkeepcalories(3000);
        user1.setUserWeightlosecalories(2000);

        Role r = new Role();
        r.setRoleName("ROLE_USER");
        roleRepository.save(r);
        user1.getRoles().add(r);
        userRepository.save(user1);

        User user2 = new User();
        user2.setLoginName("user2");
        user2.setPasswordHash(new BCryptPasswordEncoder().encode("user2"));
        user2.setUserWeightgaincalories(3000);
        user2.setUserWeightkeepcalories(2000);
        user2.setUserWeightlosecalories(1000);

        user2.getRoles().add(r);
        userRepository.save(user2);

        Product product1 = new Product();
        product1.setProductName("Kaffi");
        product1.setProductCalories("800");
        product1.setProductDescription("Caffe Latte Emmi");
        product1.setProductConsumeDate("5.7.2022");
        product1.setProductConsumeTime("12:15");
        product1.setUser(user1);
        productRepository.save(product1);
    }
}
