package com.android.dvs.machinetesthealthcoco;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class RecyclerviewAdapterEmployeeList extends RecyclerView.Adapter<RecyclerviewAdapterEmployeeList.MyHolder> {
    private Context mContext;
    private ArrayList<EmployeeModel> mEmplyList;

    public RecyclerviewAdapterEmployeeList(Context context, ArrayList<EmployeeModel> allRecords) {

        mContext = context;
        mEmplyList = allRecords;


    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.emp_list_row_item_id, parent, false);

        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {


        holder.txtName.setText(mEmplyList.get(position).getName());
        holder.txtMobile.setText(mEmplyList.get(position).getMobNo());
        holder.txtGender.setText(mEmplyList.get(position).getGender());


    }

    @Override
    public int getItemCount() {
        return mEmplyList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView txtName,txtMobile,txtGender;

        public MyHolder(View itemView) {
            super(itemView);


            txtName = itemView.findViewById(R.id.name);
            txtMobile = itemView.findViewById(R.id.mobile);
            txtGender = itemView.findViewById(R.id.gender);



        }
    }
}
