package entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class UCheck implements Serializable {

    private boolean UCHECK;
    private Date uCheckTime; // Time of start.
    private Date bannedPeriod; // Possible ban period.
    private String utorid;

    /**
     * UCheck Initialization.
     */
    public UCheck(String utorid){
        this.UCHECK = false;
        this.utorid= utorid;
    }
    /**
     * Initiates timer
     */
    public void setuCheckTime() {
        this.UCHECK = true;
        this.uCheckTime = new Date();
    }

    /**
     * @return current time of UCheck status.
     */
    public Date getuCheckTime(){
        return this.uCheckTime;
    }

    /**
     * @return String representation of User's attatched utorid ID.
     */
    public String getUtorId() {
        return utorid;
    }
    /**
     * @return boolean if its Ucheck
     */
    public boolean isUCheck() {
        return UCHECK;
    }

    /**
     * @return boolean if the timer is not over.
     */
    public boolean ucheckValid() {
        final long HOUR = 3600 * 1000; // in milli-seconds.
        Date newDate = new Date(this.uCheckTime.getTime() + 24 * HOUR);
        return (newDate.getTime() - this.uCheckTime.getTime()) < (24 * HOUR);
    }

    /**
     * If a User fails self assessment, they are banned for 14-days.
     */
    public void setBannedPeriod() {
        final long HOUR = 3600 * 1000; // in milli-seconds.
        this.bannedPeriod = new Date(this.uCheckTime.getTime() + 14 * 24 * HOUR);
    }

    /**
     * @return boolean if User ban is up or not.
     */
    public boolean checkBannedPeriodValid() {
        final long HOUR = 3600 * 1000; // in milli-seconds.
        Date newDate = new Date();
        return (newDate.compareTo(this.bannedPeriod) < (14 * 24 * HOUR));
    }
}
