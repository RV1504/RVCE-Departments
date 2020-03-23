package com.inhall.rvcedepartments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.inhall.rvcedepartments.Adapters.DepartmentsRecyclerViewAdapter;
import com.inhall.rvcedepartments.Entity.DepartmentEntity;

import java.util.ArrayList;

public class HomeScreenActivity extends AppCompatActivity implements  DepartmentsRecyclerViewAdapter.OnDepartmentClickLister {

    private TextView name;
    private RecyclerView recyclerView;
    private DepartmentsRecyclerViewAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<DepartmentEntity> departmentEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new DepartmentsRecyclerViewAdapter(this,this);
        departmentEntities = adapter.getDepartmentEntities();
        linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        addData();
    }

    private void addData() {
        final ProgressDialog progressDialog = new ProgressDialog(HomeScreenActivity.this);
        progressDialog.setMessage("Please wait");
        progressDialog.create();
        progressDialog.show();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("DEPARTMENT_LIST");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    progressDialog.dismiss();
                    for (DataSnapshot d:dataSnapshot.getChildren()) {
                        DepartmentEntity departmentEntity = d.getValue(DepartmentEntity.class);
                        departmentEntities.add(departmentEntity);
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onDepartmentClicked(DepartmentEntity departmentEntity) {
        Intent intent = new Intent(HomeScreenActivity.this, FaculityListActivity.class);
        intent.putExtra("DEPARTMENT",departmentEntity);
        startActivity(intent);
    }
}
