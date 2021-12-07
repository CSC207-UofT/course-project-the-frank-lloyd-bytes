package activities;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import controllers.RegisterController;
import dataBase.UserDBHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegisterActivity extends AppCompatActivity{
    /**
     * The registration form for new users
     * Once they successfully register they'll go back to the Login page to sign in
     */
    EditText username, password, rePassword, firstName, lastName, email, tCardNumber, year;
    Button btnSignUp, btnSignIn;
    RadioGroup status;
    RadioButton checkedButton;
    TextView department;
    boolean[] selectedDepartment;
    List<Integer> departmentList = new ArrayList<>();
    String[] departmentArray = {"CompSci", "Math", "History", "NeuroSci", "CogSci", "Music"};
    UserDBHelper DB;
    RegisterController registerController;

    /**
     * Here we are checking which radio button is selected
     * This gives us the status (student or faculty) the user selected when signing up
     */
    int checkedOrNot = 0;
    public void onRadioButtonClicked(View view) {
        int radioButtonID = status.getCheckedRadioButtonId();
        checkedButton = findViewById(radioButtonID);
        checkedOrNot = 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.registrationUserName);
        password = findViewById(R.id.registerPassword1);
        rePassword = findViewById(R.id.registerPassword2);
        firstName = findViewById(R.id.registerLegalFirstName);
        lastName = findViewById(R.id.registerLegalLastName);
        email = findViewById(R.id.registerEmail);
        tCardNumber = findViewById(R.id.registerTcardNumber);
        year = findViewById(R.id.registerYear);
        btnSignUp = findViewById(R.id.btnsignup1);
        btnSignIn = findViewById(R.id.btnsignin1);
        status = findViewById(R.id.status);
        department = findViewById(R.id.registerDepartment);
        selectedDepartment = new boolean[departmentArray.length];

        DB = new UserDBHelper(this);
        registerController = new RegisterController(DB);

        // Here we create a multi-select dropdown for the user to select the departments/programs they're in.
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

        // Here we are putting the input information to the database to create a new user object
        btnSignUp.setOnClickListener(view -> {
            if(checkedOrNot==0){
                Toast.makeText(RegisterActivity.this, "No status option picked", Toast.LENGTH_SHORT).show();
            }
            else {
                List<String> userRegistrationInfo = new ArrayList<>();
                userRegistrationInfo.add(username.getText().toString()); // username
                userRegistrationInfo.add(password.getText().toString()); // password
                userRegistrationInfo.add(rePassword.getText().toString()); // re password
                userRegistrationInfo.add(firstName.getText().toString()); // first name
                userRegistrationInfo.add(lastName.getText().toString()); // last name
                userRegistrationInfo.add(email.getText().toString()); // email
                userRegistrationInfo.add(checkedButton.getText().toString()); // status
                userRegistrationInfo.add(department.getText().toString()); // department
                userRegistrationInfo.add(tCardNumber.getText().toString().trim()); // TCard number
                userRegistrationInfo.add(year.getText().toString().trim()); // year

                String registrationMessage = registerController.runRegister(userRegistrationInfo);
                Toast.makeText(RegisterActivity.this, registrationMessage, Toast.LENGTH_SHORT).show();
            }});
        // back to login page
        btnSignIn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });
    }
}
