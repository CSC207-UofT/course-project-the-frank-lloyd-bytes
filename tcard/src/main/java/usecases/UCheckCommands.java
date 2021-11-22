package usecases;

import entities.UCheck;
import entities.User;
import usecases.UserCommands;


import java.io.Serializable;
import java.util.Date;

public class UCheckCommands implements Serializable {

    private final String USER; // not sure how to pass this into here
    private UCheck UCHECK;

    public UCheckCommands(String utorid) {
        this.USER = utorid;
        this.UCHECK = new UCheck(this.USER);

    }

    /**
     * @param status if User passes UCheck self-assessment, update it's corresponding UCheck information.
     */
    public void setUCheck(boolean status) {
        if (status){
           this.UCHECK.setUCheckTime();
        }
    }

    /**
     * @param status User is banned due to COVID restrictions.
     */
    public void setUCheckBanned(boolean status){
        if (status){
        this.UCHECK.setBannedPeriod();
        }
    }

    /**
     * @return Date is current time of User's UCheck for UI display.
     */
    public Date getUCheckTime(){
        return this.UCHECK.getUCheckTime();
    }
}
