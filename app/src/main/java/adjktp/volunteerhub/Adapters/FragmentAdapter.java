package adjktp.volunteerhub.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import adjktp.volunteerhub.Fragments.LeftFragment;


public class FragmentAdapter extends FragmentPagerAdapter {


    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LeftFragment();
        } else if (position == 1) {
            return new LeftFragment();

        } else {
            return new LeftFragment();

        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}
