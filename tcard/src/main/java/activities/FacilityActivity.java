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
import entities.Facility;
import usecases.FacilityMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FacilityActivity extends AppCompatActivity {
    Button requestAccess;
    TextView facilityName;
    FacilityManager facilityManager;
    RecyclerView recyclerView;
    FacilityAdapter adapter;
    UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_main);
        userManager = (UserManager) getIntent().getSerializableExtra("manager");
        facilityName = findViewById(R.id.facilityName);
        try {
            facilityManager = new FacilityManager();
        } catch (IOException e) {
            e.printStackTrace();
        }


        recyclerView = findViewById(R.id.listOfFaculties);
        adapter = new FacilityAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

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