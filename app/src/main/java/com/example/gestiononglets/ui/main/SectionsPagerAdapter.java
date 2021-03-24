package com.example.gestiononglets.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.gestiononglets.R;

import java.util.Locale;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //return PlaceholderFragment.newInstance(position + 1);

        switch (position) {
            case 0:
                return SeasonFragment.newInstance(0, mContext.getString(R.string.hiver));
            case 1:
                return SeasonFragment.newInstance(1, mContext.getString(R.string.printemps));
            case 2:
                return SeasonFragment.newInstance(2, mContext.getString(R.string.été));
            case 3:
                return SeasonFragment.newInstance(2, mContext.getString(R.string.automne));
            case 4:
                return SeasonFragment.newInstance(2, mContext.getString(R.string.saisons));
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return mContext.getString(R.string.hiver).toUpperCase(l);
            case 1:
                return mContext.getString(R.string.printemps).toUpperCase(l);
            case 2:
                return mContext.getString(R.string.été).toUpperCase(l);
            case 3:
                return mContext.getString(R.string.automne).toUpperCase(l);
            case 4:
                return mContext.getString(R.string.saisons).toUpperCase(l);
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 5;
    }

    public static int getImage(String s){
        if(s.equals("hiver"))     return R.drawable.hiver;
        if(s.equals("printemps")) return R.drawable.printemps;
        if(s.equals("ete"))       return R.drawable.ete;
        if(s.equals("automne"))   return R.drawable.automne;
        return 0;
    }

}