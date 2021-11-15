package activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import controllers.FacilityManager;
import controllers.UserManager;

import java.io.IOException;


public class FacilityActivity extends AppCompatActivity {
    Button requestAccess;
    TextView facilityName;
    FacilityManager facilityManager;
    RecyclerView recyclerView;
    FacilityAdapter adapter;
    UserManager userManager;

    /**
     * starting the activity for the facility's page, programming the buttons on the screen as well as the adapter that
     * sets up the texts
     *
     * @param savedInstanceState for any information that was saved previously
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_main);
        userManager = (UserManager) getIntent().getSerializableExtra("manager");
        facilityName = findViewById(R.id.facilityName);
        requestAccess = findViewById(R.id.checkFacilityAccess);
        try {
            facilityManager = new FacilityManager();
        } catch (IOException e) {
            e.printStackTrace();
        }

        recyclerView = findViewById(R.id.listOfFaculties);
        if (facilityManager!=null){
        try {
            adapter = new FacilityAdapter(facilityManager.getFacilitiesInfoArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        requestAccess.setOnClickListener(view -> {
            String name = facilityName.getText().toString();
            boolean R = facilityManager.getFacilitiesInfo().getFacility(name).evaluate(userManager.getUser());

            if(R){
                Toast.makeText(FacilityActivity.this, "Access granted, you may visit this facility", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(FacilityActivity.this, "Access denied, you may not visit this facility", Toast.LENGTH_SHORT).show();
            }
        });
    }

}