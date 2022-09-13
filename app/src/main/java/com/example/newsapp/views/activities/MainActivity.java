package com.example.newsapp.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.newsapp.adapter.PagerAdapter;
import com.example.newsapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
// The api which I used in this app needs an API key to access it's data.
    TabLayout tabLayout;
    TabItem mHome, mScience, mHealth, mEntertainment, mTech, mSports;
    PagerAdapter pagerAdapter;
    Toolbar mToolbar;
    String api = "6c2421d5b3174ab5b768cc14dbccc3ba"; // Ye api key hai. This api requires authentication. Authentication means that when we want to fetch data, we must pass authentication key as a header. It is present in documentation of newsapi.org
//    The url from which we will fetch data is present in the Endpoints section of the documentation. There we can select the country India also by adding 'in' into the url. NOTE - ALL THE DETAILS ARE PRESENT IN THE 'articles' TYPE 'ARRAY'. 'articles' types of array is present in another {}, so we have to create two Model Classes.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mHome = findViewById(R.id.home);
        mScience = findViewById(R.id.science);
        mSports = findViewById(R.id.sports);
        mEntertainment = findViewById(R.id.entertainment);
        mHealth = findViewById(R.id.health);
        mTech = findViewById(R.id.technology);

        ViewPager viewPager = findViewById(R.id.fragmentContainer);
        tabLayout = findViewById(R.id.include);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6); // 6 is the number of fragments
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5){
//                    Means if user clicks on any of the tabs -
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        Work of tab layout is complete now.
    }
}







