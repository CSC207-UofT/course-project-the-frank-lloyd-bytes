package activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import controllers.FacilityManager;
import controllers.MerchantManager;
import controllers.UserManager;
import dataBase.FileReader;

import java.io.IOException;
import java.util.List;


public class MerchantActivity extends AppCompatActivity {
    Button seeDiscounts;
    TextView merchantName;
    MerchantManager merchantManager;
    RecyclerView recyclerView;
    MerchantAdapter merchantAdapter;
    UserManager userManager;
    FileReader merchantReader = new FileReader("tcard/MerchantsData.csv");

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
        merchantName = findViewById(R.id.merchantName);
        seeDiscounts = findViewById(R.id.seeYourDiscounts);
        try {
            merchantManager = new MerchantManager(merchantReader.reader(), userManager);
        } catch (IOException e) {
            e.printStackTrace();
        }

        recyclerView = findViewById(R.id.listOfMerchants);
        if (merchantManager!=null){
            try {
                merchantAdapter = new MerchantAdapter();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        recyclerView.setAdapter(merchantAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        seeDiscounts.setOnClickListener(view -> {
            String applicableDiscounts = merchantManager.checkApplicableDiscounts(merchantName.getText().toString());

            Toast.makeText(MerchantActivity.this, applicableDiscounts, Toast.LENGTH_SHORT).show();
        });
    }

}