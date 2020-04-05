package com.inhall.rvcedepartments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.inhall.rvcedepartments.Adapters.FaculityListRecyclerViewAdapter;
import com.inhall.rvcedepartments.Entity.DepartmentEntity;
import com.inhall.rvcedepartments.Entity.FaculityListEntity;

import java.util.ArrayList;

public class FaculityListActivity extends AppCompatActivity {
    private DepartmentEntity departmentEntity;

    private RecyclerView recyclerView;
    private FaculityListRecyclerViewAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<FaculityListEntity> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculity_list);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new FaculityListRecyclerViewAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this);
        arrayList = adapter.getFaculityListEntities();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        departmentEntity = getIntent().getParcelableExtra("DEPARTMENT");
        if (departmentEntity == null){
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            return;
        }

        addData();

    }

    private void addData() {
        for (int i = 0; i < 10; i++) {
            arrayList.add(new FaculityListEntity("Test Name"+i,"test@test.com","+91 1234567890"));
        }
    }
}