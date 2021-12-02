package activities;

import interfaces.OnOptionSelection;
import adapters.QuestionAdapter;
import android.content.Intent;
import entities.UCheckQuestions;
import models.Question;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import controllers.UCheckManager;
import controllers.UserManager;
import java.util.List;

public class UCheckQuestionnaireActivity extends AppCompatActivity implements OnOptionSelection {
    UserManager myManager;
    UCheckManager myUCheckManager;
    Button btnSubmit;
    ListView listView;
    QuestionAdapter questionAdapter;
    List<Question> questions;
    ImageView imgBack;
    /**
     * @param savedInstanceState the previous saved state in other activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucheck_questionnaire);

        // We get the user information from the USER object by using a controller (myManager)
       // myManager = (UserManager) getIntent().getSerializableExtra("manager");

        // UCheck information from UCheck object in controller.
      //  myUCheckManager = (UCheckManager) getIntent().getSerializableExtra("ucheck manager");


        btnSubmit = findViewById(R.id.btnSubmit);
        listView = findViewById(R.id.listView);
        imgBack = findViewById(R.id.imgBack);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        questions = UCheckQuestions.getQuestions();
        questionAdapter = new QuestionAdapter(questions,this,this);
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
                for(Question question:questions) {
                    if(!question.isSelected) {
                        Toast.makeText(UCheckQuestionnaireActivity.this,"Please Answer All Questions",Toast.LENGTH_LONG).show();
                        return;
                    }
                }

                boolean isAllowed = true;
                // This is the logic to pass the questionnaire, as with original UCheck. Here without vaccine proof. It fails the test.
                if(questions.get(0).isNo) {
                    isAllowed = false;
                }
                else {
                    for(int i = 1; i < questions.size(); i++) {
                        if(!questions.get(i).isNo) {
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
     * @param isNo     boolean value to pass in interface whether an option has been selection in UI.
     * @param position integer position of where in UI the selection has been made.
     */
    @Override
    public void onSelection(boolean isNo, int position) {
        Question question = questions.get(position);
        question.setSelected(true);
        question.isNo = isNo;
        questions.set(position, question);
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