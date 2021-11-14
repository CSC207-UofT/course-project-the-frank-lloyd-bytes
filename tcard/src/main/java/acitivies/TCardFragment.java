package acitivies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class TCardFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.tcard_tab_fragment, container, false);
        TextView firstName = view.findViewById(R.id.tName);
        TextView lastName = view.findViewById(R.id.tLastName);
        TextView utorID = view.findViewById(R.id.tUtorID);
        TextView number = view.findViewById(R.id.tCardNo);
        Bundle bundle = getArguments();
        firstName.setText(bundle.getString("fName"));
        lastName.setText(bundle.getString("lName"));
        utorID.setText(bundle.getString("uID"));
        number.setText(bundle.getString("no"));

        return view;
    }

}