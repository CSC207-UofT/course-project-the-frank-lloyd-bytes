package models;

/**
 * This model is a UCheck data structure, which contains Date and state information about UCheck result,
 * which is connected with a User (Faculty/Student) upon registration. Every User must have a UCheck to confirm COVID-19 safety protocols.
 */
public class UCheckResult {

    String date; //default "": updates when questionnaire is complete
    int state; // default 0: 1 = pass, 2 = fail.

    public UCheckResult() {}

    /**
     * @return String value of date and initiates timer after.
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date String reference of the date that the result ended with.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return integer of the current state after results.
     */
    public int getState() {
        return state;
    }

    /**
     * @param state integer of current state after results. 1 = pass, 2 = fail, 0 default
     */
    public void setState(int state) {
        this.state = state;
    }
}
