package com.android.dvs.machinetesthealthcoco;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class ViewpagerActivity extends AppCompatActivity  implements interface_click{

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private RecyclerView mRecyclerviewListEmp;
    private Toolbar mToolbar;
    private String TAG = ViewpagerActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        mToolbar = findViewById(R.id.toolbar);

        SharedPreferences shared = getSharedPreferences("MyPref", MODE_PRIVATE);
        String UserName = (shared.getString("UserName", ""));

        Log.d(TAG, "onCreate: "+UserName);

        mToolbar.setTitle(UserName);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //addTabs(viewPager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        addTabs(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //


    }

    private void addTabs(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new DisplayListEmployeeFragment(), "One");
        adapter.addFrag(new DisplayListFragment(), "Two");
        adapter.addFrag(new SampleFragment(), "Three");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void oninterfaceClick() {
        Intent intent = new Intent(ViewpagerActivity.this,Activity_AddNewEmployee.class);
        startActivity(intent);
    }


}
