package controllers;

import interfaces.UserReadWriter;
import java.util.List;

/**
 * Use case for user registration.
 */
public class RegisterHelper {
    UserReadWriter userReadWriter;

    /**
     * The "output" of this use case.
     */
    public enum RegistrationResult {
        EMPTY_FIELD, EMAIL_ERROR, PASSWORD_MISMATCH, TCARD_NUM_ERROR, YEAR_ERROR, USER_EXISTS, REGISTER_FAILURE,
        REGISTER_SUCCESS
    }

    /**
     * Constructs a RegisterUseCase instance
     * @param userReadWriter an instance of the database helper interface UserReadWriter
     */
    public RegisterHelper(UserReadWriter userReadWriter) {
        this.userReadWriter = userReadWriter;
    }

    /**
     * Checks the validity of the user registration info in userRegistrationInfo and tries to add this info to the user
     * database.
     * @param userRegistrationInfo A list of strings containing user registration info
     * @return a RegistrationResult constant indicating the status of the registration
     */
    public RegistrationResult registerUser(List<String> userRegistrationInfo) {
        String username = userRegistrationInfo.get(0);
        String password = userRegistrationInfo.get(1);
        String rePassword = userRegistrationInfo.get(2);
        String firstName = userRegistrationInfo.get(3);
        String lastName = userRegistrationInfo.get(4);
        String mail = userRegistrationInfo.get(5);
        String status = userRegistrationInfo.get(6);
        String department = userRegistrationInfo.get(7);
        String tCardNumber = userRegistrationInfo.get(8);
        String year = userRegistrationInfo.get(9);

        // check if there are any empty fields
        for (String field : userRegistrationInfo) {
            if (field.equals("")) {
                return RegistrationResult.EMPTY_FIELD;
            }
        }

        // check if the passwords match
        if (!password.equals(rePassword)) {
            return RegistrationResult.PASSWORD_MISMATCH;
        }

        // check if email is a U of T email
        if (!mail.split("@", 2)[1].equals("mail.utoronto.ca")) {
            return RegistrationResult.EMAIL_ERROR;
        }

        // check if TCard number has correct length
        if (tCardNumber.length() != 10) {
            return RegistrationResult.TCARD_NUM_ERROR;
        }

        // check that the year is greater than zero
        if (Integer.parseInt(year) <= 0) {
            return RegistrationResult.YEAR_ERROR;
        }

        // check if a user with this username already exists
        if (userReadWriter.checkUtorID(username)) {
            return RegistrationResult.USER_EXISTS;
        }

        // register a new user in the database
        Boolean registerUserInfo = userReadWriter.insertData(username, password, firstName, lastName, mail, department,
                status, tCardNumber, year, " ");

        if (registerUserInfo) {
            return RegistrationResult.REGISTER_SUCCESS;
        } else {
            return RegistrationResult.REGISTER_FAILURE;
        }
    }
}
