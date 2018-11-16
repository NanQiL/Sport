package com.example.w.sport.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.example.w.sport.R;

import cn.bmob.v3.Bmob;

public class MainActivity extends ActionBarActivity {
    private Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "313f2b3eef7c91af8a7f3a4512619ea8");
        setContentView(R.layout.activity_main);

        login=(Button)findViewById(R.id.btn_Login);
        register=(Button)findViewById(R.id.btn_Register);

//        login.setOnClickListener(this);
//        register.setOnClickListener(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }

}
