package com.android.dvs.machinetesthealthcoco;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
class DisplayListEmployeeFragment extends Fragment {

    private interface_click mInterface_click;
    private RecyclerView mRecyclerviewListEmp;
    private RecyclerviewAdapterEmployeeList mRecyclerviewAdapterEmployeeList;
    private DatabaseHelper db;

    @Override
    public void onAttach(Context context) {

        mInterface_click = (interface_click) context;
        super.onAttach(context);


    }

    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_addemployee, container, false);
        db = new DatabaseHelper(getActivity());

        mRecyclerviewListEmp = view.findViewById(R.id.recyclerviewListEmp_Id);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerviewListEmp.setLayoutManager(layoutManager);


        mRecyclerviewAdapterEmployeeList = new RecyclerviewAdapterEmployeeList(getActivity(),db.getAllRecords());
        mRecyclerviewListEmp.setAdapter(mRecyclerviewAdapterEmployeeList);
        // mRecyclerviewAdapterEmployeeList.notifyDataSetChanged();




        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mInterface_click.oninterfaceClick();



             //   Intent intent = new Intent(getActivity(), NewMessageActivity.class);
               // startActivity(intent);
            }
        });






        return view;



    }






}
