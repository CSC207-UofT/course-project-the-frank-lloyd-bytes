package controllers;

import usecases.UCheckCommands;
import java.io.Serializable;
import java.util.Date;

public class UCheckManager implements Serializable {
    private final UCheckCommands UCheckCommands;

    /**
     * create a new UCheckManager creates a new UCheckCommands
     * @param utorid utorid ID of User.
     */
    public UCheckManager(String utorid){
        this.UCheckCommands = new UCheckCommands(utorid);
    }
    /**
     * @param status Completed the self-assessment page successfully.
     */
    public void setUCheckStatus(boolean status) {
        this.UCheckCommands.setUCheck(status);
    }
}


