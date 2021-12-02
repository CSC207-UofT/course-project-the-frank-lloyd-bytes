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
    FileReader fileReader;

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
        //facilityManager = new FacilityManager();
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
        facilitiesInfo = fileReader.reader();

        /*ArrayList<String> lineOne = new ArrayList<>();
        ArrayList<String> lineTwo = new ArrayList<>();
        lineOne.add("oneone");
        lineOne.add("onetwo");
        lineTwo.add("twoone");
        lineTwo.add("twotwo");
        facilitiesInfo.add(lineOne);
        facilitiesInfo.add(lineTwo);*/
    }
}