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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.inhall.rvcedepartments.Adapters.FaculityListRecyclerViewAdapter;
import com.inhall.rvcedepartments.Entity.DepartmentEntity;
import com.inhall.rvcedepartments.Entity.FaculityListEntity;

import java.util.ArrayList;

public class FaculityListActivity extends AppCompatActivity {
    private DepartmentEntity departmentEntity;

    private RecyclerView recyclerView;
    private FaculityListRecyclerViewAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<FaculityListEntity> faculityListEntities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculity_list);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new FaculityListRecyclerViewAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this);
        faculityListEntities = adapter.getFaculityListEntities();

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
        final ProgressDialog progressDialog = new ProgressDialog(FaculityListActivity.this);
        progressDialog.setMessage("Please wait");
        progressDialog.create();
        progressDialog.show();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("FACULTY_LIST");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    progressDialog.dismiss();
                    for (DataSnapshot d:dataSnapshot.getChildren()) {
                        //DepartmentEntity departmentEntity = d.getValue(DepartmentEntity.class);
                        FaculityListEntity faculityListEntity=d.getValue(FaculityListEntity.class);

                        faculityListEntities.add(faculityListEntity);

                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    //@Override
    /*public void onDepartmentClicked(DepartmentEntity departmentEntity) {
        //Intent intent = new Intent(FaculityListEntity.this, FaculityListActivity.class);
        intent.putExtra("DEPARTMENT",departmentEntity);
        startActivity(intent);
    }*/
    public void logout(View view)
    {
        FirebaseAuth.getInstance().signOut();//logout of user
        startActivity(new Intent(getApplicationContext(),login.class));
        finish();
    }
}
