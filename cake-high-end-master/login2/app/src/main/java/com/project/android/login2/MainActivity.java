package com.project.android.login2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //密码为空时点击登录按钮会提示信息“输入的密码不能为空”
        final Button btn_login = findViewById(R.id.login_btn_login);
        final EditText et_password = findViewById(R.id.login_et_password);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_password.length()==0){
                    Toast.makeText(MainActivity.this,"输入的密码不能为空",Toast.LENGTH_SHORT).show();
                }

            }
        });

        //用户名为空时，不能点击登录按钮，输入用户名之后才可以点击
        final EditText et_username = findViewById(R.id.login_et_username);
        et_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (TextUtils.isEmpty(et_username.getText())){
                    btn_login.setEnabled(Boolean.FALSE);
                }
                else {
                    btn_login.setEnabled(Boolean.TRUE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

}
