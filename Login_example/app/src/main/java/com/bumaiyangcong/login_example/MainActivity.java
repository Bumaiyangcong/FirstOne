package com.bumaiyangcong.login_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText username;
    private EditText password;
    private CheckBox remember;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取相应控件
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.passWord);
        remember = (CheckBox) findViewById(R.id.remember);
        login = (Button) findViewById(R.id.login);
        //设置点击事件
        login.setOnClickListener(this);
    }

    private void login() {
        String username1 = username.getText().toString().trim();
        String password1 = password.getText().toString().trim();
        boolean rememberChecked = remember.isChecked();
        if (TextUtils.isEmpty(username1) || TextUtils.isEmpty(password1)) {
            Toast.makeText(MainActivity.this, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        //判断是否记住密码，如果记住，则保存到本地
        if (rememberChecked) {
            boolean result = UserInfoUtil.saveUserInfo(username, password);
            if (result) {
                Toast.makeText(MainActivity.this, "用户名密码保存成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "用户名密码保存失败", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(MainActivity.this, "无需保存", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                login();
            default:
                break;
        }
    }
}
