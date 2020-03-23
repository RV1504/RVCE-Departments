package com.inhall.rvcedepartments.ViewHolders;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.inhall.rvcedepartments.Entity.DepartmentEntity;
import com.inhall.rvcedepartments.R;

import java.util.ArrayList;

public class DepartmentsRecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView departentName;
    public DepartmentsRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        departentName = itemView.findViewById(R.id.department_name);
    }

    public void polulate(DepartmentEntity departmentEntity){
        itemView.setTag(departmentEntity);
        departentName.setText(departmentEntity.getDepartmentName());
    }
}
