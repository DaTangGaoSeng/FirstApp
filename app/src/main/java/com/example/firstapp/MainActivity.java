package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String username = "";
    private String password = "";
    private EditText editText_username;
    private EditText editText_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =findViewById(R.id.toolbar);
        setActionBar(toolbar);
        Button button_1 = findViewById(R.id.btn_username);
        Button button_2 = findViewById(R.id.btn_sinaweibo_load);
        Button button_3 = findViewById(R.id.tencentweibo_load);
        Button button_4 = findViewById(R.id.register);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_username:
                Intent intent = new Intent(this,LoadActivity.class);
                startActivityForResult(intent,1);
                break;
            case R.id.btn_sinaweibo_load:
                Toast.makeText(MainActivity.this,"嗯，我是新浪微博",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tencentweibo_load:
                Toast.makeText(MainActivity.this,"我是腾讯微博",Toast.LENGTH_SHORT).show();;
                break;
            case R.id.register:
                Intent intent1 = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent1);
        }
    }
    }

