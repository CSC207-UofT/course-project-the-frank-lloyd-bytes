package activities;
import android.content.ContentResolver;
import android.net.Uri;
import android.widget.*;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import dataBase.UCheckDBHelper;
import dataBase.UserDBHelper;
import java.util.ArrayList;
import java.util.Collections;

public class RegisterActivity extends AppCompatActivity{
    /**
     * The registration form for new users
     * Once they succesfully register they'll go back to the Login page to sign in
     */
        EditText username, password, repassword, firstname, lastname, email, tcardNumber, year;
        Button btnsignup, btnsignin;
        RadioGroup status;
        RadioButton checkedButton;
        TextView department;
        boolean[] selectedDepartment;
        ArrayList<Integer> departmentList = new ArrayList<>();
        String[] departmentArray = {"CompSci", "Math", "History", "NeuroSci", "CogSci", "Music"};
        UserDBHelper DB;
        UCheckDBHelper UCDB

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

            username = findViewById(R.id.registrationUserName);
            password = findViewById(R.id.registerPassword1);
            repassword = findViewById(R.id.registerPassword2);
            firstname = findViewById(R.id.registerLegalFirstName);
            lastname = findViewById(R.id.registerLegalLastName);
            email = findViewById(R.id.registerEmail);
            tcardNumber = findViewById(R.id.registerTcardNumber);
            year = findViewById(R.id.registerYear);
            btnsignup = findViewById(R.id.btnsignup1);
            btnsignin = findViewById(R.id.btnsignin1);
            status = findViewById(R.id.status);
            department = findViewById(R.id.registerDepartment);
            selectedDepartment = new boolean[departmentArray.length];
            DB = new UserDBHelper(this);
            UCDB = new UCheckDBHelper(this);

            /**
             * Here we create a multi-select dropdown for the
             * user to select the departments/programs they're in
             */
            department.setOnClickListener(view -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setTitle("Select Department");
                builder.setCancelable(false);
                // records which boxes are checked
                builder.setMultiChoiceItems(departmentArray, selectedDepartment,
                        (dialogInterface, i, b) -> {
                            if(b){
                                //if the checkbox is selected then add department to the list
                                departmentList.add(i);
                                //sort department list
                                Collections.sort(departmentList);
                                }
                            else{
                                //if the checkbox is unchecked then remove the department from the list
                                int j;
                                j = departmentList.indexOf(i);
                                departmentList.remove(j);
                                }
                        });
                builder.setPositiveButton("Submit", (dialogInterface, i) -> {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int j=0; j<departmentList.size(); j++){
                        stringBuilder.append(departmentArray[departmentList.get(j)]);
                        if (j!= departmentList.size()-1){
                            stringBuilder.append(" , ");
                        }
                    }
                    department.setText(stringBuilder.toString());

                });
                builder.setNeutralButton("Clear All", (dialogInterface, i) -> {
                    //cleans all the selected boxes so the user can start with an empty department section
                    for (int j = 0; j < selectedDepartment.length; j++) {
                        selectedDepartment[j] = false;
                        departmentList.clear();
                        department.setText("");
                    }
                });
                builder.show();
            });

            /**
             * Here we are putting the input information to the database to create a new user object
             */

            btnsignup.setOnClickListener(view -> {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String firstName = firstname.getText().toString();
                String lastName = lastname.getText().toString();
                String mail = email.getText().toString();
                String userStatus = checkedButton.getText().toString();
                String depart = department.getText().toString();

                // checking if there are any empty fields
                if(user.equals("")||pass.equals("")||repass.equals("")||firstName.equals("")||lastName.equals("")
                        ||mail.equals("")||depart.equals("")||userStatus.equals("")
                        ||TextUtils.isEmpty(tcardNumber.getText().toString().trim())
                        ||TextUtils.isEmpty(year.getText().toString().trim())){
                    Toast.makeText(RegisterActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();}
                else{
                    int tNumber = tcardNumber.length();
                    int yearUofT = Integer.parseInt(year.getText().toString().trim());
                    String[] tokens = mail.split("@", 2);
                    //checking if the input information is valid
                    if(pass.equals(repass) && tokens[1].equals("mail.utoronto.ca")
                            && tNumber==10 && (yearUofT!=0)) {
                        Boolean checkUser = DB.checkutorid(user);
                        // creating a new user if one with the same userid doesn't already exist
                        // (if they do exist, they should just sign in)
                        if(!checkUser){
                            Boolean insert = DB.insertData(user, pass, firstName,
                                    lastName, mail, (String) department.getText(), userStatus, tcardNumber.getText().toString(),
                                    year.getText().toString(), "");
                                    // Assigns UCheck with User Identity once User is registered successfully.
                                    Boolean insert_UC = UCDB.insertData(tcardNumber.getText().toString(), "false");

                            if(insert){
                                Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                // back to login page to sign in
                                Intent intent2 = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent2);
                            }else{
                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Re-check the entered information", Toast.LENGTH_SHORT).show();
                    }
                } });
            // back to login page
            btnsignin.setOnClickListener(view -> {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            });
        }
    /**
     * Here we are checking which radio button is selected
     * This gives us the status (student or faculty) the user selected when signing up
     */
    public void onRadioButtonClicked(View view) {
        int radiobuttonid = status.getCheckedRadioButtonId();
        checkedButton = findViewById(radiobuttonid);
    }
}
