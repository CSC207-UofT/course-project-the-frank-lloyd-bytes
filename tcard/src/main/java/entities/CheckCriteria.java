package entities;

public interface CheckCriteria {
    /**
     * interface for checking if the user has access to the facility
     * @param user since used in facility class, checked with facility to see if user has criteria for entry
     * @return boolean that shows if user can enter the facility
     */
    boolean evaluate(User user);
}
