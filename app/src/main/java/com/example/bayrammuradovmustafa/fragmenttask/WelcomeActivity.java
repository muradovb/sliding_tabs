package com.example.bayrammuradovmustafa.fragmenttask;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;



import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity implements Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener,Tab3.OnFragmentInteractionListener {

        Toolbar toolbar;
        ArrayList<MyModel> modelList = new ArrayList<MyModel>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                fillArray();
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_welcome);
                TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
                tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
                tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
                tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
                tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
                final ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
                final PageAdapter adapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), modelList, this);
                viewPager.setAdapter(adapter);
                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                tabLayout.setupWithViewPager(viewPager);
                setupIcons(tabLayout);
                tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                        @Override
                        public void onTabSelected(TabLayout.Tab tab) {
                                viewPager.setCurrentItem(tab.getPosition());
                        }

                        @Override
                        public void onTabUnselected(TabLayout.Tab tab) {

                        }

                        @Override
                        public void onTabReselected(TabLayout.Tab tab) {

                        }
                });

        }

        @Override
        public void onFragmentInteraction(Uri uri) {

        }


        private void fillArray() {
                int [] icons = {R.drawable.ic_notification, R.drawable.ic_settings, R.drawable.ic_share};
                String [] txt = {"notifications", "settings", "share"};

                for (int i=0; i<3;i++) {
                       MyModel temp = new MyModel();
                       temp.setIcons(icons[i]);
                       temp.setText(txt[i]);
                       modelList.add(temp);
                }
        }

        private void setupIcons(TabLayout tabLayout) {
                for(int i =0; i<3; i++) {
                        tabLayout.getTabAt(i).setIcon(modelList.get(i).getIcons());
                        tabLayout.getTabAt(i).setText(modelList.get(i).getText());
                }
        }

}
