package adapters;

import fragmentAndView.QRCodeFragment;
import fragmentAndView.TCardFragment;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class DashBoardFragmentsAdapter extends FragmentStateAdapter {
    /**
     * We are using an adapter as a bridge between the ViewPager2 and the Fragments in it
     * This adapter makes it possible for the fragments to be viewed in the dashboard (through the ViewPager2)
     * It also takes in bundle arguments so that the fragments can get data from the DashBoardActivity
     */
    Bundle bundle;
    Fragment tCardFragment;
    Fragment qrCodeFragment;
    public DashBoardFragmentsAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,
                                     Bundle bundle){
        super(fragmentManager,lifecycle);
        this.bundle=bundle;
    }

    @NonNull
    @Override
    /*
      Here we are assigning each tab/page in the ViewPager2 a Fragment by calling the fragments
     */
    public Fragment createFragment(int position){
        if (position == 1) {
            qrCodeFragment = new QRCodeFragment();
            qrCodeFragment.setArguments(bundle);
            return qrCodeFragment;
        }
        tCardFragment = new TCardFragment();
        tCardFragment.setArguments(bundle);
        return tCardFragment;
    }

    /*
      We are overriding the method to input that we have two Fragments displayed in the ViewPager2
     */
    @Override
    public int getItemCount(){
        return 2;
    }
}