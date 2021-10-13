import java.util.ArrayList;

/**
 * Implements Faculty class which is a child of User class
 *
 * TODO Attributes and Representational Invarients
 */
public class Faculty extends User{
    public Faculty(String password, String status, ArrayList<String> accesses) {
        super(null, password, status, accesses);
    }

    @Override
    public String profileDisplay() {
        // TODO: finish writing method
    }
}
