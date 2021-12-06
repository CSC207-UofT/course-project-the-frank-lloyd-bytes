package activities;

import adapters.DashBoardFragmentsAdapter;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import controllers.UserManager;
import usecases.UCheckCommands;

import java.util.ArrayList;
import java.util.List;

public class DashBoardActivity extends AppCompatActivity{
    /**
     * This is the Dashboard of the app
     * Has a bottom navigation menu to direct to other pages + logs out the user
     * Has a tab layout which displays a TCard image (Fragment) and QRCode (Fragment)
     */
    TabLayout tabLayout;
    ViewPager2 viewPager;
    Switch viewMode;
    EditText username;
    CardView uCheckCard;
    TextView uCheckResult;
    DashBoardFragmentsAdapter adapter;
    BottomNavigationView bottomMenu;
    UserManager myManager;
    UCheckCommands myUCheckCommands;

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_page);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        viewMode = findViewById(R.id.moodSwitcher);
        uCheckCard = findViewById(R.id.uCheckCard);
        bottomMenu = findViewById(R.id.bottomMenu);
        uCheckResult = findViewById(R.id.uCheckTestResult);
        username = findViewById(R.id.userNameInput);
        myManager = (UserManager) getIntent().getSerializableExtra("manager");
        myUCheckCommands = new UCheckCommands();




        // This part control the switch button for the day-night mode
        // Note: it's not working perfectly, but it doesn't glitch at least
        // I'll make it work perfectly if UofT hires us to use the app irl
        SharedPreferences sharedPreferences = getSharedPreferences("AppSettingPrefs", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // here we check if the nightMode is on or not to decide which state the button should be at
        viewMode.setChecked(!sharedPreferences.getBoolean("nightMode", false));
        // here we change the default mode when the switch is moved by the user
        // the editor passes on if we're on the nightMode or not, so the state is saved
        viewMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                editor.putBoolean("nightMode", true);
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                editor.putBoolean("nightMode", false);
            }
            editor.apply();
            editor.commit();
        });







        //Add previous Activity results back in SharedPreferences.
        myUCheckCommands.populateResult(this, myManager.getId());
        //Get previous state.
        int layoutInt = myUCheckCommands.getState();
        //Once a questionnaire is completed, this method sets the UCheck results
        //UCheck of questionnaire of USER.
        if (layoutInt == 2){
            uCheckCard.setCardBackgroundColor(ContextCompat.getColor(this, R.color.negativeUCheck));
            uCheckResult.setText("UCheck Failed");
        }
        else if(layoutInt == 1){
            uCheckCard.setCardBackgroundColor(ContextCompat.getColor(this, R.color.positiveUCheck));
            uCheckResult.setText("UCheck Passed");
        }
        else {
            uCheckCard.setCardBackgroundColor(ContextCompat.getColor(this, R.color.neutralUCheck));
            uCheckResult.setText("Take UCheck Test");
        }

        /*
          This is the bottom navigation menu
          each case represents the icon clicked and which page clicking on the icon should direct the user to
         */
        bottomMenu.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.profileActivity:
                    Intent intent1 = new Intent(getApplicationContext(), ProfileActivity.class);
                    intent1.putExtra("manager", myManager);
                    startActivity(intent1);
                    break;
                case R.id.facilityActivity:
                    Intent intent = new Intent(getApplicationContext(), FacilityActivity.class);
                    intent.putExtra("manager", myManager);
                    startActivity(intent);
                    break;
                case R.id.loginActivity:
                    Intent intent3 = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.merchantActivity:
                    Intent intent4 = new Intent(getApplicationContext(), MerchantActivity.class);
                    intent4.putExtra("manager", myManager);
                    startActivity(intent4);
                    break;
            }
            return true;
        });

        FragmentManager fm = getSupportFragmentManager();

        Bundle bundle = new Bundle();
        List<String> info = myManager.getInfo();
        bundle.putString("fName", info.get(2));
        bundle.putString("lName", info.get(3));
        bundle.putString("uID", info.get(0));
        bundle.putString("no", info.get(5));
        bundle.putString("pic", info.get(9));
        List<String> criteria = new ArrayList<>();
        criteria.add(info.get(4));
        criteria.add(info.get(7));
        criteria.add(info.get(8));
        String uCheck ="";

        if (layoutInt == 1){
            uCheck = "UCheck Passed";}
        else if(layoutInt == 2){
            uCheck = "UCheck Failed";
        }
        else{
            uCheck = "UCheck Not Done";
        }
        criteria.add(uCheck);
        bundle.putString("allInfo", criteria.toString());

        adapter = new DashBoardFragmentsAdapter(fm, getLifecycle(), bundle);
        viewPager.setAdapter(adapter);
        tabLayout.addTab(tabLayout.newTab().setText("TCard"));
        tabLayout.addTab(tabLayout.newTab().setText("QR Code"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // We are changing the view between different tabs (fragments) one tab will show the TCard while the other shows
        // a QR code the method below helps us navigate between the tabs so we can go back and forth between them
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
    public void onUCheckCardClick(View view) {
        Intent intent4 = new Intent(getApplicationContext(), UCheckScrollingActivity.class);
        intent4.putExtra("manager", myManager);
        startActivity(intent4);
    }
}