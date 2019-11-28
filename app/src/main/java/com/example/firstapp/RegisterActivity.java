package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private String username = "";
    private String password = "";
    private EditText editText_username;
    private EditText editText_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setActionBar(toolbar);
        Button button_regist = findViewById(R.id.btn_register);
        editText_password = findViewById(R.id.password);
        editText_username = findViewById(R.id.username);
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                username = editText_username.getText().toString();
                password = editText_password.getText().toString();
                if (username.length() == 0 || password.length() == 0 || username.contains(" ") || password.contains(" ")) {
                    Toast.makeText(RegisterActivity.this, "用户名或密码不能为空，不能包含空格", Toast.LENGTH_SHORT).show();
                } else if (sharedPreferences.contains(username))
                    Toast.makeText(RegisterActivity.this, "该用户名已注册", Toast.LENGTH_SHORT).show();
                else if (password.length() < 6 || containChinese(password)) {
                    Toast.makeText(RegisterActivity.this, "密码长度至少6位且不能包含中文和空格", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                    editor.putString(username, password);
                    editor.apply();
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }

    //网上借鉴的判断字符串是否有中文的方法
    static private boolean containChinese(String s) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(s);
        if (m.find())
            return true;
        else
            return false;
    }
}

