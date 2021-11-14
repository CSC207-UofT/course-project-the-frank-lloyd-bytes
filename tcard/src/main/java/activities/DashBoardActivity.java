package activities;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class DashBoardActivity extends AppCompatActivity{
    TabLayout tabLayout;
    ViewPager viewPager;
    BottomNavigationView bottomMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_page);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        bottomMenu = findViewById(R.id.bottom_menu);
        bottomMenu.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.profileActivity:
                    Intent intent1 = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.facilityActivity:
                    Intent intent2 = new Intent(getApplicationContext(), FacilityActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.loginActivity:
                    Intent intent3 = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent3);
                    break;

            }
            return true;
        });
        tabLayout.addTab(tabLayout.newTab().setText("TCard"));
        tabLayout.addTab(tabLayout.newTab().setText("Vaccine Passport"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final DashBoardFragmentsAdapter adapter = new DashBoardFragmentsAdapter(getSupportFragmentManager(),
                this, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}