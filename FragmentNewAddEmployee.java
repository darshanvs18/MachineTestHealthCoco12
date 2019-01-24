package com.android.dvs.machinetesthealthcoco;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentNewAddEmployee extends Fragment {

    private EditText mEdt_Name,mEdt_Gender,mEdt_Mobile;
    private Button mButtonAddEmployee;
    private DatabaseHelper db;
    private AddEmplyeeSuccess addEmplyeeSuccess;

    @Override
    public void onAttach(Context context) {

        addEmplyeeSuccess = (AddEmplyeeSuccess) context;

        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_add_layout,container,false);

        db = new DatabaseHelper(getActivity());

        mEdt_Name = view.findViewById(R.id.edt_enterName_Id);
        mEdt_Gender = view.findViewById(R.id.edt_enterGender_Id);
        mEdt_Mobile = view.findViewById(R.id.edt_enterMobile_Id);
        mButtonAddEmployee = view.findViewById(R.id.btn_AddEmployee_Id);

        mButtonAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = mEdt_Name.getText().toString().trim();
                String gender = mEdt_Gender.getText().toString().trim();
                String mobno = mEdt_Mobile.getText().toString().trim();


                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(gender)  ||TextUtils.isEmpty(mobno)  ){

                    Toast.makeText(getActivity(),"Enter Complete Details",Toast.LENGTH_LONG).show();

                }
                else {

                    long insetflag =  db.addEmployee(name,mobno,gender);


                    if (insetflag == -1)
                    {
                        Toast.makeText(getActivity(),"Error in  Inserted",Toast.LENGTH_LONG).show();

                        //
                    }
                    else {

                        Toast.makeText(getActivity(),"Sucessfully Inserted",Toast.LENGTH_LONG).show();
                        addEmplyeeSuccess.onsuccess(insetflag);

                    }


                }




            }
        });











        return view;


    }
}
