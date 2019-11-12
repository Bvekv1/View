//package com.rohankharel.recyclerviewfragments;
package  com.work.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.rohankharel.recyclerviewfragments.adapter.ViewPagerAdapter;
//import com.work.view.R;
import com.work.view.fragment.LoginFragment;
import com.work.view.fragment.RegisterFragment;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        //fragments added
        viewPagerAdapter.addFragment(new LoginFragment(),"Login");
        viewPagerAdapter.addFragment(new RegisterFragment(),"Register");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
