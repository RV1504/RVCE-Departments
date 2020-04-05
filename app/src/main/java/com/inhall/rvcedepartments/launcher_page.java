package com.inhall.rvcedepartments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class launcher_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_page);
        //setContentView(R.layout.activity_main);
        Thread t=new Thread()
        {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(2000);
                    Intent i1=new Intent(launcher_page.this,MainActivity.class);
                    startActivity(i1);
                    finish();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
