package com.example.w.sport.view.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.w.sport.R;
import com.example.w.sport.presenter.impl.LoginPresenterImpl;
import com.example.w.sport.presenter.inter.LoginPresenter;
import com.example.w.sport.view.inter.LoginView;

/**test
 * Created by WCF on 2018/6/26.
 */
public class LoginActivity extends ActionBarActivity implements LoginView, View.OnClickListener{
    private EditText et_login_phone,et_login_password;
    private Button btn_phone_clear,btn_pwd_clear,btn_pwd_eye;
    private Button btn_login;
    private TextView tv_forget_password;
    private Button btn_login_qq,btn_login_weChat;
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        btn_login.setOnClickListener(this);
        btn_phone_clear.setOnClickListener(this);
        btn_pwd_clear.setOnClickListener(this);

        loginPresenter=new LoginPresenterImpl();

    }
    public void init(){
        et_login_phone=(EditText)findViewById(R.id.et_login_phone);
        et_login_password=(EditText)findViewById(R.id.et_login_password);
        btn_phone_clear=(Button)findViewById(R.id.btn_phone_clear);
        btn_pwd_clear=(Button)findViewById(R.id.btn_pwd_clear);
        btn_pwd_eye=(Button)findViewById(R.id.btn_pwd_eye);
        btn_login=(Button)findViewById(R.id.btn_login);
        tv_forget_password=(TextView)findViewById(R.id.tv_forget_password);
        btn_login_qq=(Button)findViewById(R.id.btn_login_qq);
        btn_login_weChat=(Button)findViewById(R.id.btn_login_weChat);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_phone_clear:
                loginPresenter.clearPhone();
                break;
            case R.id.btn_pwd_clear:
                loginPresenter.clearPassword();
                break;
            case R.id.btn_login:
                loginPresenter.doLogin(et_login_phone.getText().toString(), et_login_password.getText().toString());
                break;
        }
    }
    @Override
    public void onClearPhone() {
        et_login_phone.setText(null);
    }

    @Override
    public void onClearPassword() {
        et_login_password.setText(null);
    }

    @Override
    public void onLoginResult(Boolean result, int code) {

    }
}
