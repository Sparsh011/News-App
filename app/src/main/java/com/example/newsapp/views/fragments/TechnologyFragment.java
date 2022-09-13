package com.example.newsapp.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.adapter.Adapter;
import com.example.newsapp.api.ApiUtilities;
import com.example.newsapp.api.MainNews;
import com.example.newsapp.api.ModelClass;
import com.example.newsapp.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TechnologyFragment extends Fragment {
    String api = "6c2421d5b3174ab5b768cc14dbccc3ba";
    Adapter adapter;
    ArrayList<ModelClass> modelClassArrayList;
    String country = "in";
    private RecyclerView mRecyclerViewOfTechnology;
    private String category = "technology";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.technologyfragment, null);
        mRecyclerViewOfTechnology = view.findViewById(R.id.recyclerViewOfTech);
        modelClassArrayList = new ArrayList<>();
        mRecyclerViewOfTechnology.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        mRecyclerViewOfTechnology.setAdapter(adapter);

        findNews();

        return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country, category, 100, api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}
