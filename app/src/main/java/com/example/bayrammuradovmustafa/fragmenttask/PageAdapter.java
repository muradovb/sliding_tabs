package com.example.bayrammuradovmustafa.fragmenttask;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import java.util.ArrayList;


public class PageAdapter extends FragmentStatePagerAdapter {

    //properies
    int mNoOfTabs;
    ArrayList<MyModel> mdlList;
    Context context;

    //constructor
    public PageAdapter(FragmentManager fm, int NumberOfTabs, ArrayList<MyModel> lst, Context cntxt)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
        this.mdlList=lst;
        context=cntxt;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                Tab1 tab1 = new Tab1();
                return tab1;
            case 1:
                Tab2 tab2 = new Tab2();
                return  tab2;
            case 2:
                Tab3 tab3 = new Tab3();
                return  tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable drawable=context.getResources().getDrawable(mdlList.get(position).getIcons());
        ImageSpan imageSpan= new ImageSpan(drawable);
        SpannableString spannableString = new SpannableString("");
        return spannableString;
    }
}