package adapters;

import android.annotation.SuppressLint;
import interfaces.OnOptionSelection;
import models.Question;
import activities.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.List;

/**
 * This adapter allows UCheckQuestions be inputted into the proper view for UCheckQuestionnaireActivity. This class also
 * determines button selection functionality.
 */
public class QuestionAdapter extends BaseAdapter {
    private final List<Question> listData;
    Context context;

    /**
     */
    OnOptionSelection onOptionSelection;
    public QuestionAdapter(List<Question> listData, Context context, OnOptionSelection onOptionSelection) {
        this.listData = listData;
        this.context=context;
        this.onOptionSelection=onOptionSelection;
    }

    /**
     * @return integer of list size.
     */
    @Override
    public int getCount() {
        return listData.size();
    }

    /**
     * @param position integer position of item.
     * @return boolean default just to override.
     */
    @Override
    public Object getItem(int position) {
        return null;
    }

    /**
     * @param position integer position of item.
     * @return int default 0 just to override.
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * @param position integer position of view to be.
     * @param convertView View that coverts default view.
     * @param parent the parent of the previous view.
     * @return View for display.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint({"ViewHolder", "InflateParams"}) View itemView= LayoutInflater.from(context).inflate(R.layout.question_layout,null,false);
        TextView  txtTitle = itemView.findViewById(R.id.txtQuestionTitle);
        TextView txtQuestion = itemView.findViewById(R.id.txtQuestion);
        RadioButton  radioButtonNo = itemView.findViewById(R.id.radioNo);
        RadioButton  radioButtonYes = itemView.findViewById(R.id.radioYes);
        RadioGroup radiogroup = itemView.findViewById(R.id.radiogroup);
        Question mQuestion = listData.get(position);
        txtTitle.setText(mQuestion.getTitle());
        txtQuestion.setText(mQuestion.getQuestion());
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            // This determines whether a button has been selected in UI, it also enforces 1 button per yes/no layer.
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (radioButtonNo.isChecked()) {
                    onOptionSelection.onSelection(true, position);
                }
                if (radioButtonYes.isChecked()) {
                    onOptionSelection.onSelection(false, position);
                }

            }
        });
        return itemView;
    }
}
