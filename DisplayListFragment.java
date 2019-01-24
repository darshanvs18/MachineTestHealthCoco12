package com.android.dvs.machinetesthealthcoco;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
class DisplayListFragment extends Fragment {

    private String URL ="https://androidtutorialpoint.com/api/volleyJsonArray";
    private ImageView imageview;
    private TextView mRom,mScreensize,mBackcamera,mCompanyname,mName;
    private RecyclerviewAdapter mRecyclerviewAdapter;
    private RecyclerView mRecyclerview;
    private RequestQueue mRequestQueue;
    private ArrayList<Model> mModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_displaylist, container, false);
        mModel = new ArrayList<>();
        mRecyclerview = view.findViewById(R.id.recyclerview_Id);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerview.setLayoutManager(layoutManager);

        mRequestQueue= Volley.newRequestQueue(getActivity());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
/*

                for(int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        mModel.add(jsonObject.toString());
                    }
                    catch(JSONException e) {
                        mModel.add("Error: " + e.getLocalizedMessage());
                    }
                }
*/

                Gson gson = new Gson();
                Type listType = new TypeToken<List<Model>>(){}.getType();
                List<Model> posts = gson.fromJson(response.toString(), listType);
                mRecyclerviewAdapter = new RecyclerviewAdapter(getActivity(),posts);
                mRecyclerview.setAdapter(mRecyclerviewAdapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(jsonArrayRequest);

        return view;
    }




}
