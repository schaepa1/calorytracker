package ch.zhaw.sml.iwi.meng.calorytracker.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    @Query("SELECT p FROM Product p WHERE p.user.loginName = ?1 AND p.productDate = ?2")
    public List<Product> findProductByUserandDate(String UserLoginName, String ProductDate);

}