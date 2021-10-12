import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is an abstract class that is a base for all user classes
 *
 */


public abstract class User {
//    TODO create abstract attributes for all users such as unique identifier
    private ArrayList profile;
    private String uniqueID;
//    TODO create expanded data appropriate initializer
    public User(ArrayList information) {
        this.profile = information;
    }
}
