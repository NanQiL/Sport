package com.example.w.sport.view.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.w.sport.R;
import com.example.w.sport.model.User;
import com.example.w.sport.view.inter.RegisterView;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by WCF on 2018/6/26.
 */
public class RegisterActivity extends ActionBarActivity implements View.OnClickListener,RegisterView {
    private EditText et_register_phone,et_register_password,et_verification_code;
    private Button btn_send_code,btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "313f2b3eef7c91af8a7f3a4512619ea8");
        setContentView(R.layout.activity_register);
        init();
        btn_register.setOnClickListener(this);

    }

    public void init(){
        et_register_phone=(EditText)findViewById(R.id.et_register_phone);
        et_register_password=(EditText)findViewById(R.id.et_register_password);
        et_verification_code=(EditText)findViewById(R.id.et_verification_code);
        btn_send_code=(Button)findViewById(R.id.btn_send_code);
        btn_register=(Button)findViewById(R.id.btn_register);
    }

    @Override
    public void onClick(View v){
        User user=new User();
        String phone=et_register_phone.getText().toString();
        String password=et_register_password.getText().toString();
        switch (v.getId()){
            case R.id.btn_register:
                if(TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)){
                    Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                user.setPhone(phone);
                user.setPassword(password);
                user.setSex("12");
                user.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId,BmobException e) {
                        if (e == null) {
                            Toast.makeText(getBaseContext(), "注册成功", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;
            default:
                break;
        }
    }

    @Override
    public void onRegisterResult() {

    }
}
