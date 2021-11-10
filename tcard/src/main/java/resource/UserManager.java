package resource;


import dataBase.DBHelper;

/**This class is a usecase class for managing User information.
 */
public class UserManager {

    public String context;

    public void setPasswordDB(String context){
        // TODO figure out update password inside of Database
        DBHelper.setpassword(context);

}
