package ch.zhaw.sml.iwi.meng.calorytracker.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import java.sql.Time;
@Entity
public class TProduct {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int productId;
    private String productName;
    private String productCalories;
    private String productDescription;
    private long productEan;
    public long getProductEan() {
        return productEan;
    }
    public void setProductEan(long productEan) {
        this.productEan = productEan;
    }
    @Basic
    private Time productConsumetime;
    @ManyToOne
    private TCaloryTrackDay calorytrackday;
    
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
    public Time getProductConsumetime() {
        return productConsumetime;
    }
    public void setProductConsumetime(Time productConsumetime) {
        this.productConsumetime = productConsumetime;
    }
}
