// Menu Class gets user inputs to navigate app services

//==== Atributes ====

//===== =====

import java.util.ArrayList;

/**
 * This class will temporarily get user data from terminal interface,
 * and from Userdata. MEANING THIS IS BOTH PRESENTATION AND CONTROLLER LEVEL COMBINED>
 * However, it will employ separate interfaces in future for this functionality.
 * NOTE, ALL VARIABLES ARE TEMPORARY FOR NOW! WE WILL DETERMINE TYPE OR CLASS USAGE
 * AFTER FLOW IS DETERMINED:)
 */
// TODO class attributes -> Must interact with commands that get imputs and return info to display.
// TODO class methods should interact with only the layer below which will be the business rules
//    or user cases commands, this I temporarily named UserCommand class.
public class Menu {
    public String[] buildMenu(boolean saveState) {
//        TODO 1. Initialize the menu class, determine how to check for load state( saved or new state?)
//        ** I think that using two different menu initializers ie: overloading makes sense here
//        as the shell state can pass a booleen which will determine the menu type (new/loaded)
//       TODO  2. If saved run method with populated menu options for saved state.
//
    }
//  TODO   newUserMenu method will need to employ either a form or multiple prompts
//    in order to retrieve user data ( Example for student prompt form
//    Tcard #, Name, email, and other personal info.)
    public void newUserMenu(ArrayList newUser) {

    }
//  TODO menuDisplay method , this method is the visual component of the menu printed on the terminal
//    it will require string modifications for any class info displayed from User types (make
//    sure string display format is set for each user class and as an Abstract requirement in USER class.

    public String menuDisplay(){
//        Basic welcome that shows current user info and options
    }


}
