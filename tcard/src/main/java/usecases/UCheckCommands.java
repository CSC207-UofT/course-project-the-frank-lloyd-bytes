package usecases;

import entities.UCheck;
import entities.User;
import usecases.UserCommands;


import java.io.Serializable;
import java.util.Date;

public class UCheckCommands implements Serializable {

    private UserCommands USERCOMMANDS; // not sure how to pass this into here
    private UCheck UCHECK;

    public UCheckCommands(String utorid) {
        this.UCHECK = this.createUCheck();
    }
    /**
     * Initializes UCheck Entity on creation of User.
     */
    public UCheck createUCheck(){
        return new UCheck(this.USERCOMMANDS.getId());
    }

    /**
     * @param status if User passes UCheck self-assessment, update it's corresponding UCheck information.
     */
    public void setUCheck(boolean status) {
        if (status){
           this.UCHECK.setuCheckTime();
        }
    }

    /**
     * @param status User is banned due to COVID restrictions.
     */
    public void setUCheckBanned(boolean status){
        this.UCHECK.setBannedPeriod();
    }

    /**
     * @return Date is current time of User's UCheck.
     */
    public Date getUCheckTime(){
        return this.UCHECK.getuCheckTime();
    }
}
