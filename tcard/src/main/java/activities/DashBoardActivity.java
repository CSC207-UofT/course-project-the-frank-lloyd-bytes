package activities;
import android.annotation.SuppressLint;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import controllers.UserManager;

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
    EditText username;
    DashBoardFragmentsAdapter adapter;
    BottomNavigationView bottomMenu;
    UserManager myManager;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_page);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        bottomMenu = findViewById(R.id.bottomMenu);
        username = findViewById(R.id.userNameInput);
        myManager = (UserManager) getIntent().getSerializableExtra("manager");

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
                    startActivity(intent);
                    break;
                case R.id.loginActivity:
                    Intent intent3 = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent3);
                    break;

            }
            return true;
        });

        FragmentManager fm = getSupportFragmentManager();

        Bundle bundle = new Bundle();
        List<String> info = myManager.getinfo();
        bundle.putString("fName", info.get(2));
        bundle.putString("lName", info.get(3));
        bundle.putString("uID", info.get(0));
        bundle.putString("no", info.get(5));
        List<String> criteria = new ArrayList<>();
        criteria.add(info.get(4));
        criteria.add(info.get(7));
        criteria.add(info.get(8));
        bundle.putString("allInfo", criteria.toString());

        adapter = new DashBoardFragmentsAdapter(fm, getLifecycle(), bundle);
        viewPager.setAdapter(adapter);
        tabLayout.addTab(tabLayout.newTab().setText("TCard"));
        tabLayout.addTab(tabLayout.newTab().setText("QR Code"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        /*
          We are changing the view between different tabs (fragments)
          one tab will show the TCard while the other shows a QR code
          the method below helps us navigate between the tabs so we can go back and forth between them
         */
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
}