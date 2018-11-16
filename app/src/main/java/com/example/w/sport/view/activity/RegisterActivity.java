package com.example.w.sport.view.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.w.sport.R;
import com.example.w.sport.presenter.impl.RegisterPresenterImpl;
import com.example.w.sport.presenter.inter.IRegisterPresenter;
import com.example.w.sport.view.inter.IRegisterView;

import cn.bmob.v3.Bmob;

/**
 * Created by WCF on 2018/6/26.
 */
public class RegisterActivity extends ActionBarActivity implements View.OnClickListener,IRegisterView {
    private EditText et_register_phone,et_register_password,et_verification_code;
    private Button btn_send_code,btn_register;
    private ImageButton btn_phone_clear,btn_pwd_clear,btn_pwd_eye;
    private IRegisterPresenter registerPresenter;
    private Boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "313f2b3eef7c91af8a7f3a4512619ea8");
        registerPresenter=new RegisterPresenterImpl(this);
        setContentView(R.layout.activity_register);

        init();
        et_register_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String phone = et_register_phone.getText().toString().trim();
                if ("".equals(phone)) {
                    btn_phone_clear.setVisibility(View.INVISIBLE);
                } else {
                    btn_phone_clear.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et_register_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String pwd=et_register_password.getText().toString().trim();
                if("".equals(pwd)){
                    btn_pwd_clear.setVisibility(View.INVISIBLE);
                    btn_pwd_eye.setVisibility(View.INVISIBLE);
                }else{
                    btn_pwd_clear.setVisibility(View.VISIBLE);
                    btn_pwd_eye.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                btn_register.setEnabled(true);
            }
        });
        btn_register.setOnClickListener(this);
        btn_phone_clear.setOnClickListener(this);
        btn_pwd_clear.setOnClickListener(this);
        btn_pwd_eye.setOnClickListener(this);

    }

    public void init(){
        et_register_phone=(EditText)findViewById(R.id.et_register_phone);
        et_register_password=(EditText)findViewById(R.id.et_register_password);
        et_verification_code=(EditText)findViewById(R.id.et_verification_code);
        btn_send_code=(Button)findViewById(R.id.btn_send_code);
        btn_register=(Button)findViewById(R.id.btn_register);
        btn_phone_clear=(ImageButton)findViewById(R.id.btn_phone_clear);
        btn_pwd_clear=(ImageButton)findViewById(R.id.btn_pwd_clear);
        btn_pwd_eye=(ImageButton)findViewById(R.id.btn_pwd_eye);
    }

    @Override
    public void onClick(View v){
        String phone=et_register_phone.getText().toString();
        String password=et_register_password.getText().toString();
        switch (v.getId()){
            case R.id.btn_register:
                if(TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)){
                    Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                registerPresenter.registerResult(phone,password);
                break;
            case R.id.btn_phone_clear:
                registerPresenter.phoneClear();
                break;
            case R.id.btn_pwd_clear:
                registerPresenter.pwdClear();
                break;
            case R.id.btn_pwd_eye:
                if(flag){
                    flag=false;
                }else{
                    flag=true;
                }
                onChangePwd(flag);
                break;
            default:
                break;
        }
    }



    @Override
    public void onPhoneClear() {
        et_register_phone.setText(null);
    }

    @Override
    public void onPwdClear() {
        et_register_password.setText(null);
    }

    @Override
    public void onChangePwd(Boolean flag) {
        if(flag){
            btn_pwd_eye.setImageResource(R.drawable.password_open);
            et_register_password.setTransformationMethod(HideReturnsTransformationMethod
                    .getInstance());
        }else{
            btn_pwd_eye.setImageResource(R.drawable.password_close);
            et_register_password.setTransformationMethod(PasswordTransformationMethod
                    .getInstance());
        }
    }
}
