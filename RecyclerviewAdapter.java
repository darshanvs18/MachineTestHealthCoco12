package com.android.dvs.machinetesthealthcoco;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Model> model;

    public RecyclerviewAdapter(FragmentActivity activity, List<Model> model) {

        mContext = activity;
        this.model = model;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_id, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mRom.setText(model.get(position).getRom());
        holder.mScreensize.setText(model.get(position).getScreenSize());
        holder.mBackcamera.setText(model.get(position).getBackCamera());
        holder.mCompanyname.setText(model.get(position).getCompanyName());
        holder.mName.setText(model.get(position).getName());
        holder.battery.setText(model.get(position).getBattery());
        holder.operatingSystem.setText(model.get(position).getOperatingSystem());
        holder.processor.setText(model.get(position).getProcessor());
        holder.ram.setText(model.get(position).getRam());


        Picasso.with(mContext).load(model.get(position).getUrl()).into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView mRom,mScreensize,mBackcamera,mCompanyname,mName;
        private TextView frontCamera;
        private TextView battery;
        private TextView operatingSystem;
        private TextView processor;
        private TextView ram;

        public MyViewHolder(View itemView) {
            super(itemView);


           imageView = itemView.findViewById(R.id.image_Id);
            mRom = itemView.findViewById(R.id.rom_value_Id);
            mScreensize = itemView.findViewById(R.id.screensize_value_Id);
            mBackcamera = itemView.findViewById(R.id.backCamera_value_Id);
            mCompanyname = itemView.findViewById(R.id.companyName_value_Id);
            mName = itemView.findViewById(R.id.Name_value_Id);


            battery = itemView.findViewById(R.id.battery_value_Id);
            operatingSystem = itemView.findViewById(R.id.os_value_Id);
            processor = itemView.findViewById(R.id.processor_value_Id);
            ram = itemView.findViewById(R.id.ram_value_Id);



        }
    }
}
