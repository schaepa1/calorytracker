package ch.zhaw.sml.iwi.meng.calorytracker.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USERTABLE")
public class User {

    @Id
    private String loginName;
    private int userWeightgaincalories;
    private int userWeightlosecalories;
    private int userWeightkeepcalories;

    public int getUserWeightgaincalories() {
        return userWeightgaincalories;
    }

    public void setUserWeightgaincalories(int userWeightgaincalories) {
        this.userWeightgaincalories = userWeightgaincalories;
    }

    public int getUserWeightlosecalories() {
        return userWeightlosecalories;
    }

    public void setUserWeightlosecalories(int userWeightlosecalories) {
        this.userWeightlosecalories = userWeightlosecalories;
    }

    public int getUserWeightkeepcalories() {
        return userWeightkeepcalories;
    }

    public void setUserWeightkeepcalories(int userWeightkeepcalories) {
        this.userWeightkeepcalories = userWeightkeepcalories;
    }

    @JsonIgnore
    private String passwordHash;

    @ManyToMany
    private List<Role> roles = new ArrayList<>();

    /**
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return the passwordHash
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * @param passwordHash the passwordHash to set
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * @return the roles
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


}