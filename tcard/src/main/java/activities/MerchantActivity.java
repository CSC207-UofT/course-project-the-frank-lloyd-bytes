package activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import controllers.MerchantManager;
import controllers.UserManager;
import dataBase.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MerchantActivity extends AppCompatActivity {
    UserManager userManager;
    MerchantManager merchantManager;
    MerchantAdapter merchantAdapter;
    Button backToDashboard;

    /**
     * starting the activity for the facility's page, programming the buttons on the screen as well as the adapter that
     * sets up the texts
     *
     * @param savedInstanceState for any information that was saved previously
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_main);

        userManager = (UserManager) getIntent().getSerializableExtra("manager");

//        FileReader merchantReader = new FileReader("tcard/MerchantsData.csv");
//        List<List<String>> merchantList = null;
//        try {
//            merchantList = merchantReader.reader();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        merchantManager = new MerchantManager(merchantList, userManager);
        merchantManager = new MerchantManager(setMerchantList(), userManager);

        backToDashboard = findViewById(R.id.merchantsGoBack);

        backToDashboard.setOnClickListener(view -> {
            Intent intent4 = new Intent(getApplicationContext(), DashBoardActivity.class);
            intent4.putExtra("manager", userManager);
            startActivity(intent4);
        });

        RecyclerView recyclerView = findViewById(R.id.listOfMerchants);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        try {
            merchantAdapter = new MerchantAdapter(merchantManager);
        } catch (IOException e) {
            e.printStackTrace();
        }
        recyclerView.setAdapter(merchantAdapter);
    }

    private List<List<String>> setMerchantList() {
        List<String> merchantInfo1 = new ArrayList<>();

        merchantInfo1.add("U of T Bookstore");
        merchantInfo1.add("214 College Street");
        merchantInfo1.add("11am to 6pm");
        merchantInfo1.add("10:(textbooks/stationary):(1/2/3).(Math/CompSci):().()|20:(hats/sweaters):(any).(any):(any).(any)");

        List<String> merchantInfo2 = new ArrayList<>();

        merchantInfo2.add("Cafe Reznikoff");
        merchantInfo2.add("75 St George St");
        merchantInfo2.add("7:30am to 11pm");
        merchantInfo2.add("20:(coffee/hot chocolate):(any).(any):(any).(any)|30:(baked goods):(any).(any):(any).(any)");

        List<String> merchantInfo3 = new ArrayList<>();

        merchantInfo3.add("Diabolos' Coffee Bar");
        merchantInfo3.add("15 King's College Cir");
        merchantInfo3.add("8am to 8pm");
        merchantInfo3.add("10:(everything):().():(any).(any)");

        List<String> merchantInfo4 = new ArrayList<>();

        merchantInfo4.add("Gerstein Library");
        merchantInfo4.add("9 King's College Cir");
        merchantInfo4.add("8:30am to 10pm");
        merchantInfo4.add("5:(book rentals):(any).(any):().()");

        List<List<String>> merchantList = new ArrayList<>();

        merchantList.add(merchantInfo1);
        merchantList.add(merchantInfo2);
        merchantList.add(merchantInfo3);
        merchantList.add(merchantInfo4);

        return merchantList;
    }

}

//package activities;
//
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import controllers.MerchantManager;
//import controllers.UserManager;
//import dataBase.FileReader;
//
//import java.io.IOException;
//
//public class MerchantActivity extends AppCompatActivity {
//    Button seeDiscounts;
//    TextView merchantName;
//    MerchantManager merchantManager;
//    RecyclerView recyclerView;
//    MerchantAdapter merchantAdapter;
//    UserManager userManager;
//    FileReader merchantReader = new FileReader("tcard/MerchantsData.csv");
//
//    /**
//     * Starts the activity for the merchants page, programming the buttons on the screen as well as the adapter that
//     * sets up the texts
//     *
//     * @param savedInstanceState for any information that was saved previously
//     */
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_merchant_main);
//        userManager = (UserManager) getIntent().getSerializableExtra("manager");
//        merchantName = findViewById(R.id.merchantName);
//        seeDiscounts = findViewById(R.id.seeYourDiscounts);
//        try {
//            merchantManager = new MerchantManager(merchantReader.reader(), userManager);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        recyclerView = findViewById(R.id.listOfMerchants);
//        if (merchantManager!=null){
//            try {
//                merchantAdapter = new MerchantAdapter(userManager);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        recyclerView.setAdapter(merchantAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setHasFixedSize(true);
//
//        seeDiscounts.setOnClickListener(view -> {
//            String applicableDiscounts = merchantManager.checkApplicableDiscounts(merchantName.getText().toString());
//
//            Toast.makeText(MerchantActivity.this, applicableDiscounts, Toast.LENGTH_SHORT).show();
//        });
//    }
//
//}