package com.android.dvs.machinetesthealthcoco;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class Activity_AddNewEmployee extends AppCompatActivity implements AddEmplyeeSuccess{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_employee);
        setTitle("Add Employee Details");

        addFragment();



    }

    private void addFragment() {

        FragmentNewAddEmployee newAddEmployeeFragment = new FragmentNewAddEmployee();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.employeeAddContainer,newAddEmployeeFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }



    @Override
    public void onsuccess(long insetflag) {

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentNewAddEmployee newAddEmployeeFragment = new FragmentNewAddEmployee();
        fragmentTransaction.remove(newAddEmployeeFragment);
        fragmentTransaction.commit();
        finish();//To finish Activity

    }

    @Override
    public void onBackPressed() {

        finish();
        super.onBackPressed();
    }
}
