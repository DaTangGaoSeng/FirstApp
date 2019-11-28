package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class LoadActivity extends AppCompatActivity {
    private String username ;
    private String password ;
    private EditText editText_username;
    private EditText editText_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        Toolbar toolbar =findViewById(R.id.toolbar);
        setActionBar(toolbar);
        Button button_2 = findViewById(R.id.load);
        editText_password = findViewById(R.id.password);
        editText_username = findViewById(R.id.username);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    password = editText_password.getText().toString();
                    username = editText_username.getText().toString();
                    SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
               if(sharedPreferences.contains(username) && sharedPreferences.getString(username,"").equals(password))
               {
                    Toast.makeText(LoadActivity.this, "登陆成功",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoadActivity.this,Recycleview.class));
               }
                else
                    Toast.makeText(LoadActivity.this, "用户名或密码错误",Toast.LENGTH_SHORT).show();
            }
        });
    }
}


