import java.util.ArrayList;
import java.util.UUID;

/**
 * This is an abstract class that is a base for all user classes
 *
 */


public abstract class User {

//    TODO create abstract attributes for all users such as unique identifier
    private ArrayList<String> profile = new ArrayList<>();
    private ArrayList<String> accesses = new ArrayList<>();
    // TODO: I used constants for the profile, let me know if there is another way we want to approach this
    final int UNIQUE_ID = 0;
    // TODO: should we have a UTORid for all users or just the students? we already have a unique id for each user.
    final int UTOR_ID = 1;
    final int PASSWORD = 2;
    final int STATUS = 3;

//    TODO create expanded data appropriate initializer
    public User(String utorID, String password, String status, ArrayList<String> accesses) {
        this.profile.set(UNIQUE_ID, UUID.randomUUID().toString());
        this.profile.set(UTOR_ID, utorID);
        this.profile.set(PASSWORD, password);
        this.profile.set(STATUS, status);
        this.accesses = accesses;
//     ie:   this.profile = information;
    }
//    TODO create abstract String display modifier to force child class creation
    public abstract String profileDisplay();

//    TODO create an accessible invariant with profile data that can be accessed polymorphically
//    so that it can be saved and loaded regardless of child class.

}
