package entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class UCheck implements Serializable {

    private boolean ucheck; // is valid or not.
    private Date uchecktime; // Time of start.
    private Date bannedperiod; // Possible ban period.
    private final String utorid; // student number.

    /**
     * UCheck Initialization.
     */
    public UCheck(String utorid){
        this.ucheck = false;
        this.utorid= utorid;

    }
    /**
     * Initiates timer
     */
    public void setUCheckTime() {
        this.ucheck = true;
        this.uchecktime = new Date();
        this.bannedperiod = new Date(System.currentTimeMillis() - 24*3600*1000);
    }

    /**
     * @return current time of UCheck status.
     */
    public Date getUCheckTime(){
        return this.uchecktime;
    }

    /**
     * @return String representation of User's attatched utorid ID.
     */
    public String getUTorId() {
        return utorid;
    }
    /**
     * @return boolean if its Ucheck
     */
    public boolean isUCheck() {
        return ucheck;
    }

    /**
     * @return true if the timer is not over and banned is past
     */
    public boolean uCheckValid() {
        final long HOUR = 3600 * 1000; // in milli-seconds.
        Date newDate = new Date(this.uchecktime.getTime() + 24 * HOUR);
        return (newDate.getTime() - this.uchecktime.getTime()) < (24 * HOUR) && this.bannedperiod.before(new Date());
    }

    /**
     * If a User fails self assessment, they are banned for 14-days.
     */
    public void setBannedPeriod() {
        final long HOUR = 3600 * 1000; // in milli-seconds.
        this.bannedperiod = new Date(this.uchecktime.getTime() + 14 * 24 * HOUR);
    }

    /**
     * @return true if User is banned.
     */
    public boolean uCheckBannedPeriodValid() {
        return this.bannedperiod.after(new Date());
    }
}
