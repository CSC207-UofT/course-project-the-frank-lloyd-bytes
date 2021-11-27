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
        }
    }
    /**
     * @return Date is current time of User's UCheck for UI display.
     */
    public Date getUCheckTime(){
        return this.UCHECK.getUCheckTime();
    }

    /**
     * This method interacts with UCheckScrollingActivity's results of the self assessment. If it's true, additional
     * methods will call to form successful completion of self-assessment questionnaire.
     * TODO front-end needs to send a list collected from the checked boxes here.
     * @param responses is a String of responses completed by the self-assessment.
     * @return boolean on whether the self-assessment is success or failure.
     */
    public boolean ucheckResponses(ArrayList<String> responses){
        if (Objects.equals(responses.get(0), "yes")){
             for (int i = 1; i < 8; i++)
                 if(Objects.equals(responses.get(i), "no")){
                     return true;
            }
        }
        return false;
    }
    // TODO implement below method that checks activity. Default will be grey box. All three boxes will be hidden.

    /**
     * @return integer into UCheckActivity that will determine which coloured box appears. Grey is default and 0, whereas,
     * 1 is the Green box.
     */
    public int displayUCheck(){
        if(!(!UCHECK.isUCheck() || !UCHECK.uCheckValid())){
            return 1;
        }
        return 0;
    }

    /**
     * @param fail boolean is determined in UI.
     * @return integer that gives the correct display in UCheckActivity/
     */
    public int displayFailedUCheck(boolean fail){
        return 2;
    }
}
