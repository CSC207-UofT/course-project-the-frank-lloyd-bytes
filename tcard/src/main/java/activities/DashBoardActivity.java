package activities;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import controllers.FacilityManager;
import controllers.UserManager;

import java.util.ArrayList;

public class DashBoardActivity extends AppCompatActivity{
    /**
     * This is the Dashboard of the app
     * Has a bottom navigation menu to direct to other pages + logs out the user
     * Has a tab layout which displays a TCard image (Fragment) and QRCode (Fragment)
     */
    TabLayout tabLayout;
    ViewPager2 viewPager;
    EditText username;
    CardView uCheckCard;
    TextView uCheckResult;
    DashBoardFragmentsAdapter adapter;
    BottomNavigationView bottomMenu;
    UserManager myManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_page);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        uCheckCard = findViewById(R.id.UCheckCard);
        bottomMenu = findViewById(R.id.bottom_menu);
        uCheckResult = findViewById(R.id.uCheckTestResult);
        username = findViewById(R.id.userNameInput);
        myManager = (UserManager) getIntent().getSerializableExtra("manager");

        boolean trial = false; // gonna change this to ucheck result and gonna make the uCheckCard clickable

        if (!trial){
            uCheckCard.setCardBackgroundColor(ContextCompat.getColor(this, R.color.negativeUCheck));
            uCheckResult.setText("UCheck False");
        }
        else{
            uCheckCard.setCardBackgroundColor(ContextCompat.getColor(this, R.color.positiveUCheck));
            uCheckResult.setText("UCheck Passed");
        }


        /**
         * This is the bottom navigation menu
         * each case represents the icon clicked and which page clicking on the icon should direct the user to
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
        ArrayList<String> info = myManager.getinfo();
        bundle.putString("fName", info.get(2));
        bundle.putString("lName", info.get(3));
        bundle.putString("uID", info.get(0));
        bundle.putString("no", info.get(5));
        ArrayList criteria = new ArrayList();
        criteria.add(info.get(4));
        criteria.add(info.get(7));
        criteria.add(info.get(8));
        bundle.putString("allInfo", criteria.toString());

        adapter = new DashBoardFragmentsAdapter(fm, getLifecycle(), bundle);
        viewPager.setAdapter(adapter);
        tabLayout.addTab(tabLayout.newTab().setText("TCard"));
        tabLayout.addTab(tabLayout.newTab().setText("QR Code"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        /**
         * We are changing the view between different tabs (fragments)
         * one tab will show the TCard while the other shows a QR code
         * the method below helps us navigate between the tabs so we can go back and forth between them
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