package entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class UCheck implements Serializable {

    public boolean UCHECK;
    public Date uCheckTime;
    public Date bannedPeriod;

    /**
     * @param user User to be checked.
     */
    public UCheck(User user){
        this.UCHECK = false;
    }
    /**
     * Initiates timer
     */
    public void setuCheckTime() {
        this.UCHECK = true;
        this.uCheckTime = new Date();
    }

    /**
     * @return boolean if its Ucheck
     */
    public boolean isUCHECK() {
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
