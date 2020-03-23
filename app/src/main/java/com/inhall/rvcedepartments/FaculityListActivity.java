package com.inhall.rvcedepartments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.inhall.rvcedepartments.Entity.DepartmentEntity;

public class FaculityListActivity extends AppCompatActivity {
    private TextView textView;
    private DepartmentEntity departmentEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculity_list);

        departmentEntity = getIntent().getParcelableExtra("DEPARTMENT");
        if (departmentEntity == null){
            Toast.makeText(this, "Something went rong", Toast.LENGTH_SHORT).show();
            return;
        }

        textView = findViewById(R.id.department_name);

        textView.setText(departmentEntity.getDepartmentName());
    }
}