package ch.zhaw.sml.iwi.meng.calorytracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Entity
public class Product {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int productId;
    private String productName;
    private String productCalories;
    private String productDescription;
    private long productEan;
    private String productDate;
    private String productConsumetime;
    @ManyToOne
    private User user;
    
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductCalories() {
        return productCalories;
    }
    public void setProductCalories(String productCalories) {
        this.productCalories = productCalories;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public long getProductEan() {
        return productEan;
    }
    public void setProductEan(long productEan) {
        this.productEan = productEan;
    }
    public String getProductDate() {
        return productDate;
    }
    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }
    public String getProductConsumetime() {
        return productConsumetime;
    }
    public void setProductConsumetime(String productConsumetime) {
        this.productConsumetime = productConsumetime;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
