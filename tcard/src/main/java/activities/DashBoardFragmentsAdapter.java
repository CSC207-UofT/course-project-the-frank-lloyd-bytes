package activities;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class DashBoardFragmentsAdapter extends FragmentPagerAdapter {
    private Context context;
    int totalTabs;

    public DashBoardFragmentsAdapter(FragmentManager fragmanager, Context context, int totalTabs){
        super (fragmanager);
        this.context = context;
        this.totalTabs = totalTabs;
    }
    @Override
    public int getCount(){
        return totalTabs;
    }
    public Fragment getItem(int position){
        switch (position){
            case 0:
                TCardFragment tCardFragment =  new TCardFragment();
                return tCardFragment;
            case 1:
                VaccinePassportFragment vaccinePassportFragment =  new VaccinePassportFragment();
                return vaccinePassportFragment;
            default:
                return null;
        }
    }

}