package com.inhall.rvcedepartments.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.inhall.rvcedepartments.Entity.FaculityListEntity;
import com.inhall.rvcedepartments.R;

public class FaculityListRecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView name, email, phone;
    public FaculityListRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        email = itemView.findViewById(R.id.email);
        phone = itemView.findViewById(R.id.experience);
    }

    public void populate(FaculityListEntity entity){
        name.setText(entity.getName());
        email.setText(entity.getEmail());
        phone.setText(entity.getExperience());
    }
}

