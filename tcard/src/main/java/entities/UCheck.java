package entities;

import java.io.Serializable;
import java.util.Date;

/**This entity stores information about UCheck which is connected with a User (Faculty/Student) upon registration.
 * Every User must have a UCheck to confirm COVID-19 safety protocols.
 */
public class UCheck implements Serializable {

    private boolean ucheck; // is valid or not.
    private Date uchecktime; // Time of start.
    private final String utorid; // User utorid number.
    private int ucheckstate; // Ucheck state, 0 default, 1 completed + passed, 2 completed + failed.

    /**
     * UCheck Initialization.
     */
    public UCheck(String utorid){
        this.ucheck = false;
        this.utorid= utorid;
        this.ucheckstate = 0;
    }
    /**
     * Initiates timer
     */
    public void setUCheckTime() {
        this.ucheck = true;
        this.uchecktime = new Date();
    }
    /**
     * @return current time of UCheck status.
     */
    public Date getUCheckTime(){
        return this.uchecktime;
    }
    /**
     * @return String representation of User's attached utorid ID.
     */
    public String getUTorId() {
        return utorid;
    }

    /**
     *
     */
    public void setUCheckStatePass(){
        this.ucheckstate = 1;
    }

    /**
     *
     */
    public void setUCheckStateFail(){
        this.ucheckstate = 2;
    }
    public int getUCheckState(){
        return this.ucheckstate;
    }
    /**
     * @return boolean if its UCheck.
     */
    public boolean isUCheck() {
        return ucheck;
    }
    /**
     * @return true if the timer is not over.
     */
    public boolean uCheckValid() {
        final long HOUR = 3600 * 1000; // in milli-seconds.
        Date newDate = new Date(this.uchecktime.getTime() + 24 * HOUR);
        return (newDate.getTime() - this.uchecktime.getTime()) < (24 * HOUR);
    }
}
