package com.mycompany.talk;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycompany.talk.Fragments.MapFragment;
import com.mycompany.talk.Fragments.NewsFeedFragment;
import com.mycompany.talk.Fragments.UserProfileFragment;

/**
 * Created by joshua on 12/28/2015.
 */
public class Adapter extends FragmentPagerAdapter {
    private String fragments[] = { "News Feed","Map","Profile"};

    public Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos) {
            case 0:
                return new NewsFeedFragment();
            case 1:
                return new MapFragment();
            case 2:
                return new UserProfileFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments[position];

    }
}
