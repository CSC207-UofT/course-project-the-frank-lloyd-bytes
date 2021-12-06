package activities;

import controllers.UCheckManager;
import interfaces.OnOptionSelection;
import adapters.QuestionAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class UCheckQuestionnaireActivity extends AppCompatActivity implements OnOptionSelection {
    Button btnSubmit;
    ListView listView;
    QuestionAdapter questionAdapter;
    ImageView imgBack;
    UCheckManager myUCheckManager;
    /**
     * @param savedInstanceState the previous saved state in other activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucheck_questionnaire);
        btnSubmit = findViewById(R.id.btnSubmit);
        listView = findViewById(R.id.listView);
        imgBack = findViewById(R.id.imgBack);
        myUCheckManager = new UCheckManager();
        questionAdapter = new QuestionAdapter(myUCheckManager.getQuestions(),this,this);
        listView.setAdapter(questionAdapter);
        //the button sends us back to UCheck dashboard. With result.
        imgBack.setOnClickListener(v -> {
            setResult(RESULT_CANCELED,null);
            finish();
        });
        // Here the USER interacts with the questionnaire.
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v view of the activity.
             */
            @Override
            public void onClick(View v) {
                // If not every option is selected during the questionnaire, a Toast is sent out in UI to warn USER and stop next activity.
                if(!myUCheckManager.isAllSelected())
                {
                    Toast.makeText(UCheckQuestionnaireActivity.this,"Please Answer All Questions",Toast.LENGTH_LONG).show();
                    return;
                }
                boolean isAllowed;
                // This is the logic to pass the questionnaire, as with original UCheck. Here without vaccine proof 'yes'. It fails the test.
                isAllowed = myUCheckManager.isAllowed();
                Intent intent = getIntent();
                intent.putExtra("isAllowed", isAllowed);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    /** This method interacts with the interface and determines which question is being selected in UI. If a question is selected, it will update
     * and allows to know the question is stored in a list. When USER selects yes or no, we update that position or index selected.
     * @param isNoVar  boolean value to pass in interface whether an option has been selection in UI.
     * @param position integer position of where in UI the selection has been made.
     */
    @Override
    public void onSelection(boolean isNoVar, int position) {
        myUCheckManager.updateSelection(isNoVar, position);

    }

    /**
     * This method cancels activity and returns to UCheckScrollingActivity.
     */
    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED,null);
        finish();
    }
}