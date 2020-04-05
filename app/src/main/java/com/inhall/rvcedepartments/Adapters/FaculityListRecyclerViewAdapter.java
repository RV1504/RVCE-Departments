package com.inhall.rvcedepartments.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.inhall.rvcedepartments.Entity.FaculityListEntity;
import com.inhall.rvcedepartments.R;
import com.inhall.rvcedepartments.ViewHolders.FaculityListRecyclerViewHolder;

import java.util.ArrayList;

public class FaculityListRecyclerViewAdapter extends RecyclerView.Adapter<FaculityListRecyclerViewHolder> {
    private AppCompatActivity appCompatActivity;
    private ArrayList<FaculityListEntity> faculityListEntities;
    private LayoutInflater layoutInflater;

    public FaculityListRecyclerViewAdapter(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
        layoutInflater = appCompatActivity.getLayoutInflater();
        faculityListEntities = new ArrayList<>();
    }

    public ArrayList<FaculityListEntity> getFaculityListEntities() {
        return faculityListEntities;
    }

    @NonNull
    @Override
    public FaculityListRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.faculity_list_recycler_view_arch, parent,false);
        FaculityListRecyclerViewHolder faculityListRecyclerViewHolder = new FaculityListRecyclerViewHolder(view);
        return faculityListRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FaculityListRecyclerViewHolder holder, int position) {
        holder.populate(faculityListEntities.get(position));
    }

    @Override
    public int getItemCount() {
        return faculityListEntities.size();
    }
}