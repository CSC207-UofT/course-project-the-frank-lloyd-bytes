package controllers;

import interfaces.UserReadWriter;
import java.util.*;

/**
 * Controls the process for user registration.
 */
public class RegisterController {
    RegisterHelper registerHelper;
    final Map<RegisterHelper.RegistrationResult, String> REGISTER_MESSAGES = new EnumMap<>(RegisterHelper.RegistrationResult.class);

    /**
     * Constructor for RegisterController
     * @param userReadWriter an instance of the database helper interface UserReadWriter
     */
    public RegisterController(UserReadWriter userReadWriter) {
        this.registerHelper = new RegisterHelper(userReadWriter);

        REGISTER_MESSAGES.put(RegisterHelper.RegistrationResult.EMPTY_FIELD, "Please fill all the fields");
        REGISTER_MESSAGES.put(RegisterHelper.RegistrationResult.EMAIL_ERROR, "Email must be a U of T email");
        REGISTER_MESSAGES.put(RegisterHelper.RegistrationResult.TCARD_NUM_ERROR, "TCard number must be 10 digits long");
        REGISTER_MESSAGES.put(RegisterHelper.RegistrationResult.YEAR_ERROR, "Year must be greater than 0");
        REGISTER_MESSAGES.put(RegisterHelper.RegistrationResult.USER_EXISTS, "User already exists! Please sign in");
        REGISTER_MESSAGES.put(RegisterHelper.RegistrationResult.REGISTER_FAILURE, "Registration failed");
        REGISTER_MESSAGES.put(RegisterHelper.RegistrationResult.REGISTER_SUCCESS, "Registered successfully");
    }

    /**
     * Checks the validity of the user registration info in userRegistrationInfo and tries to add this info to the user
     * database. Returns a message describing the status of registration.
     * @param userRegistrationInfo A list of strings containing user registration info
     * @return a string with a message describing the status of the registration
     */
    public String runRegister(List<String> userRegistrationInfo) {
        RegisterHelper.RegistrationResult registerResult = registerHelper.registerUser(userRegistrationInfo);
        return REGISTER_MESSAGES.get(registerResult);
    }
}
