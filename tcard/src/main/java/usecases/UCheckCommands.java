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
     *
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

    public void setUCheckBanned(boolean status){
        this.UCHECK.setBannedPeriod();
    }
    public Date getUCheckTime(){
        return this.UCHECK.getuCheckTime();
    }
}
