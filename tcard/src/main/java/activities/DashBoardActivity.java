package activities;
import android.database.Cursor;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import controllers.UserManager;

import java.util.ArrayList;

public class DashBoardActivity extends AppCompatActivity{
    TabLayout tabLayout;
    ViewPager2 viewPager;
    EditText username;
    DashBoardFragmentsAdapter adapter;
    BottomNavigationView bottomMenu;
    UserManager myManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_page);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        bottomMenu = findViewById(R.id.bottom_menu);
        username = findViewById(R.id.userNameInput);
        myManager = (UserManager) getIntent().getSerializableExtra("manager");

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
        adapter = new DashBoardFragmentsAdapter(fm, getLifecycle(), bundle);
        viewPager.setAdapter(adapter);
        tabLayout.addTab(tabLayout.newTab().setText("TCard"));
        tabLayout.addTab(tabLayout.newTab().setText("Vaccine Passport"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

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