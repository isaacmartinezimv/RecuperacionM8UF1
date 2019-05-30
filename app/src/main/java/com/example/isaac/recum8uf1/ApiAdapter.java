package com.example.isaac.recum8uf1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ApiViewHolder> {





    @NonNull
    @Override
    public ApiAdapter.ApiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.api_item, null, false);


        return new ApiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiAdapter.ApiViewHolder apiViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ApiViewHolder extends RecyclerView.ViewHolder {
        public ApiViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
