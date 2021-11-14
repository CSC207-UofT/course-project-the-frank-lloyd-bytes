package activities;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class DashBoardFragmentsAdapter extends FragmentStateAdapter {
    Bundle bundle;
    Fragment tCardFragment;
    public DashBoardFragmentsAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,
                                     Bundle bundle){
        super(fragmentManager,lifecycle);
        this.bundle=bundle;
    }
    @NonNull
    @Override
    public Fragment createFragment(int position){
        switch (position){
            case 1:
                return new VaccinePassportFragment();
            default:
                tCardFragment = new TCardFragment();
                tCardFragment.setArguments(bundle);
                return tCardFragment;
        }
    }
    @NonNull

    @Override
    public int getItemCount(){
        return 2;
    }
}