package ch.zhaw.sml.iwi.meng.calorytracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class TCaloryTrackDay {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int calorytrackdayId;
    @Temporal(TemporalType.DATE)
    private Date calorytrackdayDate;
    @ManyToOne
    private TUser user;

    public Date getCalorytrackdayDate() {
        return calorytrackdayDate;
    }
    public void setCalorytrackdayDate(Date calorytrackdayDate) {
        this.calorytrackdayDate = calorytrackdayDate;
    }
}