package models;

/**
 * This class is a model that determines the UI values after the results from the questionnaire.
 */
public class Result {

    String date;
    int state;

    public Result() {}

    /**
     * @return String value of date.
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
     * @param state integer of current state after results.
     */
    public void setState(int state) {
        this.state = state;
    }
}
