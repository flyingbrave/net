package com.yxy.net;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.LinearLayout;




public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.view_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });







    }
}