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
    private String productConsumeDate;
    private String productConsumeTime;
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
        return productConsumeDate;
    }
    public void setProductDate(String productConsumeDate) {
        this.productConsumeDate = productConsumeDate;
    }
    public String getProductConsumetime() {
        return productConsumeTime;
    }
    public void setProductConsumetime(String productConsumeTime) {
        this.productConsumeTime = productConsumeTime;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
