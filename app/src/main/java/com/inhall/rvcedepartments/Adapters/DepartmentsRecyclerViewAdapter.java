package com.inhall.rvcedepartments.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.inhall.rvcedepartments.Entity.DepartmentEntity;
import com.inhall.rvcedepartments.R;
import com.inhall.rvcedepartments.ViewHolders.DepartmentsRecyclerViewHolder;

import java.util.ArrayList;

public class DepartmentsRecyclerViewAdapter extends RecyclerView.Adapter<DepartmentsRecyclerViewHolder> {

    private AppCompatActivity appCompatActivity;
    private ArrayList<DepartmentEntity> departmentEntities;
    private OnDepartmentClickLister onDepartmentClickLister;
    private LayoutInflater layoutInflater;

    public DepartmentsRecyclerViewAdapter(AppCompatActivity appCompatActivity, OnDepartmentClickLister onDepartmentClickLister) {
        this.appCompatActivity = appCompatActivity;
        this.onDepartmentClickLister = onDepartmentClickLister;
        departmentEntities = new ArrayList<>();
        layoutInflater = appCompatActivity.getLayoutInflater();
    }

    public ArrayList<DepartmentEntity> getDepartmentEntities() {
        return departmentEntities;
    }

    @NonNull
    @Override
    public DepartmentsRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.department_recycler_view_arch, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getTag() instanceof DepartmentEntity){
                    DepartmentEntity departmentEntity = (DepartmentEntity) v.getTag();
                    onDepartmentClickLister.onDepartmentClicked(departmentEntity);
                }
            }
        });
        return new DepartmentsRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentsRecyclerViewHolder holder, int position) {
        holder.polulate(departmentEntities.get(position));
    }

    @Override
    public int getItemCount() {
        return departmentEntities.size();
    }

    public interface OnDepartmentClickLister{
        void onDepartmentClicked(DepartmentEntity departmentEntity);
    }
}
