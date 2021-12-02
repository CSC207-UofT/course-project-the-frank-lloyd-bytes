package activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import controllers.FacilityManager;
import controllers.UserManager;
import entities.Facility;

import java.io.IOException;


public class FacilityActivity extends AppCompatActivity {
    FacilityManager facilityManager;
    RecyclerView recyclerView;
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
        try {
            facilityManager = new FacilityManager();
        } catch (IOException e) {
            e.printStackTrace();
        }

        recyclerView = findViewById(R.id.listOfFaculties);

        try {
            setAdapter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setAdapter() throws IOException {
        FacilityAdapter adapter = new FacilityAdapter(facilityManager.getFacilitiesInfoArray());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

}