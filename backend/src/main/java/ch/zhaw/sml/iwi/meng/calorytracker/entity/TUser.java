package ch.zhaw.sml.iwi.meng.calorytracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Entity
public class TUser {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;
    private String userName;
    private String userPassword;
    private String userWeightgaincalories;
    private String userWeightlosecalories;
    private String userWeightkeepcalories;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserWeightgaincalories() {
        return userWeightgaincalories;
    }
    public void setUserWeightgaincalories(String userWeightgaincalories) {
        this.userWeightgaincalories = userWeightgaincalories;
    }
    public String getUserWeightlosecalories() {
        return userWeightlosecalories;
    }
    public void setUserWeightlosecalories(String userWeightlosecalories) {
        this.userWeightlosecalories = userWeightlosecalories;
    }
    public String getUserWeightkeepcalories() {
        return userWeightkeepcalories;
    }
    public void setUserWeightkeepcalories(String userWeightkeepcalories) {
        this.userWeightkeepcalories = userWeightkeepcalories;
    }
}
