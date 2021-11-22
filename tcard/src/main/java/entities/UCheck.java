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
    public void setUCheckTime() {
        this.UCHECK = true;
        this.uCheckTime = new Date();
        this.bannedPeriod = new Date(System.currentTimeMillis() - 24*3600*1000);
    }

    /**
     * @return current time of UCheck status.
     */
    public Date getUCheckTime(){
        return this.uCheckTime;
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
        return UCHECK;
    }

    /**
     * @return true if the timer is not over and banned is past
     */
    public boolean ucheckValid() {
        final long HOUR = 3600 * 1000; // in milli-seconds.
        Date newDate = new Date(this.uCheckTime.getTime() + 24 * HOUR);
        return (newDate.getTime() - this.uCheckTime.getTime()) < (24 * HOUR) && this.bannedPeriod.before(new Date());
    }

    /**
     * If a User fails self assessment, they are banned for 14-days.
     */
    public void setBannedPeriod() {
        final long HOUR = 3600 * 1000; // in milli-seconds.
        this.bannedPeriod = new Date(this.uCheckTime.getTime() + 14 * 24 * HOUR);
    }

    /**
     * @return true if User is banned.
     */
    public boolean checkBannedPeriodValid() {
        return this.bannedPeriod.after(new Date());
    }
}
