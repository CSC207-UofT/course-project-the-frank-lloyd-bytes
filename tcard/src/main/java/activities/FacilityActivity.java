package activities;

import android.content.Intent;
import adapters.FacilityAdapter;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import controllers.FacilitiesManager;
import controllers.UserManager;
import java.io.IOException;
import java.util.ArrayList;


public class FacilityActivity extends AppCompatActivity {
    private ArrayList<ArrayList<String>> facilitiesInfo;
    FacilitiesManager facilitiesManager;
    UserManager userManager;
    FacilityAdapter adapter;
    Button backToDashboard;
    UserManager myManager;
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
        backToDashboard = findViewById(R.id.facilitiesGoBack);

        backToDashboard.setOnClickListener(view -> {
            Intent intent4 = new Intent(getApplicationContext(), DashBoardActivity.class);
            intent4.putExtra("manager", userManager);
            startActivity(intent4);
        });

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

        adapter = new FacilityAdapter(facilitiesInfo, facilitiesManager, userManager);

        recyclerView.setAdapter(adapter);
    }

    private void setFacilityInfo() throws IOException {

        //facilitiesInfo = fileReader.reader();

        ArrayList<String> facilityOne = new ArrayList<>();
        ArrayList<String> facilityTwo = new ArrayList<>();
        ArrayList<String> facilityThree = new ArrayList<>();

        facilityOne.add("Bahen");
        facilityOne.add("St George");
        facilityOne.add("library");
        facilityOne.add("9 to 5");
        facilityOne.add("program=(any),level=(undergrad):department=(any),position=(postdoc/professor)");

        facilityTwo.add("Robarts");
        facilityTwo.add("St George");
        facilityTwo.add("lab");
        facilityTwo.add("9 to 5");
        facilityTwo.add("program=(CompSci/Math),level=(1/2/3):department=(CompSci/Math),position=(4/5/6)");

        facilityThree.add("New College");
        facilityThree.add("21 classic");
        facilityThree.add("residence");
        facilityThree.add("24 hours");
        facilityThree.add("program=(Music),level=(1):department=(Music),position=(1)");
        facilitiesInfo.add(facilityOne);
        facilitiesInfo.add(facilityTwo);
        facilitiesInfo.add(facilityThree);

        facilitiesManager = new FacilitiesManager(facilitiesInfo);
    }
}