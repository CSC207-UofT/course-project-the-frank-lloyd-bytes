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
import dataBase.FileReader;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class FacilityActivity extends AppCompatActivity {
    private ArrayList<ArrayList<String>> facilitiesInfo;
    FacilityManager facilityManager;
    UserManager userManager;
    FacilityAdapter adapter;
    //FileReader fileReader;

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
        //fileReader = new FileReader();
        facilitiesInfo = new ArrayList<>();
        try {
            setFacilityInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RecyclerView recyclerView = findViewById(R.id.listOfFaculties);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new FacilityAdapter(facilitiesInfo);

        recyclerView.setAdapter(adapter);
    }

    private void setFacilityInfo() throws IOException {

        //facilitiesInfo = fileReader.reader();

        ArrayList<String> facilityOne = new ArrayList<>();
        ArrayList<String> facilityTwo = new ArrayList<>();
        facilityOne.add("Bahen");
        facilityOne.add("St George");
        facilityOne.add("library");
        facilityOne.add("9 to 5");
        facilityOne.add("program=(any),level=(undergrad):department=(any),position=(postdoc/professor)");


        facilityTwo.add("Robarts");
        facilityTwo.add("St George");
        facilityTwo.add("lab");
        facilityTwo.add("9 to 5");
        facilityTwo.add("program=(CS),level=(undergrad):department=(CS),position=(postdoc/professor)");
        facilitiesInfo.add(facilityOne);
        facilitiesInfo.add(facilityTwo);
    }
}