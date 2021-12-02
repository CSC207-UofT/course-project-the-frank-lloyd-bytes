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
}
