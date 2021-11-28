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
     * This method interacts with UCheckScrollingActivity's results of the self assessment. If it's true, additional
     * methods will call to form successful completion of self-assessment questionnaire.
     * TODO front-end needs to send a list collected from the checked boxes here.
     * @param responses is a String of responses completed by the self-assessment.
     */
    public void ucheckResponses(ArrayList<String> responses){
        if (Objects.equals(responses.get(0), "yes")){
             for (int i = 1; i < 8; i++)
                 if(Objects.equals(responses.get(i), "no")){
                     this.setUCheck(true);
            }
        }
        else{
            this.setUCheck(false);
        }
    }

    /**
     * @return integer value of state, 0 default (untested), 1 tested + passed, 2 tested + failed.
     */
    public int getUCheckState() {
        return this.UCHECK.getUCheckState();

    }
}
