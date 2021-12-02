package activities;

import entities.UCheckQuestion;
import entities.UCheckQuestions;
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
import java.util.List;

public class UCheckQuestionnaireActivity extends AppCompatActivity implements OnOptionSelection {
    Button btnSubmit;
    ListView listView;
    QuestionAdapter questionAdapter;
    List<UCheckQuestion> myUCheckQuestions;
    ImageView imgBack;
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
        myUCheckQuestions = UCheckQuestions.getQuestions();
        questionAdapter = new QuestionAdapter(myUCheckQuestions,this,this);
        listView.setAdapter(questionAdapter);
        //the button sends us back to UCheck dashboard. With result.
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED,null);
                finish();
            }
        });
        // Here the USER interacts with the questionnaire.
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            /**
             * @param v view of the activity.
             */
            @Override
            public void onClick(View v) {
                for(UCheckQuestion UCheckQuestion : myUCheckQuestions) {
                    if(!UCheckQuestion.isSelected()) {
                        Toast.makeText(UCheckQuestionnaireActivity.this,"Please Answer All Questions",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                boolean isAllowed = true;
                // This is the logic to pass the questionnaire, as with original UCheck. Here without vaccine proof 'yes'. It fails the test.
                if(myUCheckQuestions.get(0).isNo()) {
                    isAllowed = false;
                }
                else {
                    for(int i = 1; i < myUCheckQuestions.size(); i++) {
                        if(!myUCheckQuestions.get(i).isNo()) {
                            isAllowed = false;
                            break;
                        }
                    }
                }
                Intent intent = getIntent();
                intent.putExtra("isAllowed", isAllowed);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    /** This method interacts with the interface.
     * @param isNoVar     boolean value to pass in interface whether an option has been selection in UI.
     * @param position integer position of where in UI the selection has been made.
     */
    @Override
    public void onSelection(boolean isNoVar, int position) {
        UCheckQuestion UCheckQuestion = myUCheckQuestions.get(position);
        UCheckQuestion.setSelected(true);
        UCheckQuestion.setIsNo(isNoVar);
        myUCheckQuestions.set(position, UCheckQuestion);
    }

    /**
     *
     */
    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED,null);
        finish();
    }
}