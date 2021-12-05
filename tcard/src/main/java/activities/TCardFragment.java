package activities;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class TCardFragment extends Fragment{
    /**
     * This is one of the fragments that's displayed in the Dashboard through ViewPager2
     * A TCard is displayed (appearance similar to the physical TCard, the profile pic will come in Phase 2)
     * We get the information displayed from the USER Object
     * (User -->UserCommands-->UserManager-->Dashboard(myManager-->Bundle)-->FragmentAdapter(bundle)-->Fragment)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.tcard_tab_fragment, container, false);
        TextView firstName = view.findViewById(R.id.tName);
        TextView lastName = view.findViewById(R.id.tLastName);
        TextView utorID = view.findViewById(R.id.tUtorID);
        TextView number = view.findViewById(R.id.tCardNo);
        ImageView profile = view.findViewById(R.id.profilePic);
        Bundle bundle = getArguments();
        firstName.setText(bundle.getString("fName"));
        lastName.setText(bundle.getString("lName"));
        utorID.setText(bundle.getString("uID"));
        number.setText(bundle.getString("no"));
        if (bundle.getString("pic") != " "){
           profile.setImageURI(Uri.parse(bundle.getString("pic")));
        }


        return view;
    }

}