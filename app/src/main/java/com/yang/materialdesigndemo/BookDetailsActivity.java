package com.yang.materialdesigndemo;

import android.content.res.AssetManager;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDetailsActivity extends AppCompatActivity {

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        collapsingToolbarLayout.setTitle("失控");

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        initViewPager();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("内容简介"));
        tabLayout.addTab(tabLayout.newTab().setText("作者详情"));
        tabLayout.addTab(tabLayout.newTab().setText("目录"));
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initViewPager(){

        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(DetailsFragment.newInstance(getAsset("book_content.txt")));
        fragments.add(DetailsFragment.newInstance(getAsset("book_author.txt")));
        fragments.add(DetailsFragment.newInstance(getAsset("book_menu.txt")));

        final List<String> titles= new ArrayList<>();
        titles.add("内容简介");
        titles.add("作者详情");
        titles.add("目录");
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        };

        viewPager.setAdapter(adapter);
    }

    private String getAsset(String fileName) {
        AssetManager am = getResources().getAssets();
        InputStream is = null;
        try {
            is = am.open(fileName, AssetManager.ACCESS_BUFFER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Scanner(is).useDelimiter("\\Z").next();
    }

}
