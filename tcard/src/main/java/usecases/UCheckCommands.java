package usecases;

import entities.UCheck;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 */
public class UCheckCommands implements Serializable {

    private final String USER;
    private final UCheck UCHECK;

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
           this.UCHECK.setUCheckStatePass();
        }
        else{
            this.UCHECK.setUCheckStateFail();
        }
    }
    /**
     * @return Date is current time of User's UCheck for UI display.
     */
    public Date getUCheckTime(){
        return this.UCHECK.getUCheckTime();
    }
    /**
     * @return integer value of state, 0 default (untested), 1 tested + passed, 2 tested + failed.
     */
    public int getUCheckState() {
        return this.UCHECK.getUCheckState();
    }
}
