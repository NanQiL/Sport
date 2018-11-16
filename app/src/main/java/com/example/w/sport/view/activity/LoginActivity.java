package com.example.w.sport.view.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.w.sport.R;
import com.example.w.sport.presenter.impl.LoginPresenterImpl;
import com.example.w.sport.presenter.inter.ILoginPresenter;
import com.example.w.sport.view.inter.ILoginView;

/**test
 * Created by WCF on 2018/6/26.
 */
public class LoginActivity extends ActionBarActivity implements ILoginView, View.OnClickListener{
    private EditText et_login_phone,et_login_password;
    private ImageButton btn_phone_clear,btn_pwd_clear,btn_pwd_eye;
    private Button btn_login;
    private TextView tv_forget_password;
    private ImageButton btn_login_qq,btn_login_weChat;
    ILoginPresenter ILoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        btn_login.setOnClickListener(this);
        btn_phone_clear.setOnClickListener(this);
        btn_pwd_clear.setOnClickListener(this);

        ILoginPresenter =new LoginPresenterImpl();

    }
    public void init(){
        et_login_phone=(EditText)findViewById(R.id.et_login_phone);
        et_login_password=(EditText)findViewById(R.id.et_login_password);
        btn_phone_clear=(ImageButton)findViewById(R.id.btn_phone_clear);
        btn_pwd_clear=(ImageButton)findViewById(R.id.btn_pwd_clear);
        btn_pwd_eye=(ImageButton)findViewById(R.id.btn_pwd_eye);
        btn_login=(Button)findViewById(R.id.btn_login);
        tv_forget_password=(TextView)findViewById(R.id.tv_forget_password);
        btn_login_qq=(ImageButton)findViewById(R.id.btn_login_qq);
        btn_login_weChat=(ImageButton)findViewById(R.id.btn_login_weChat);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_phone_clear:
                ILoginPresenter.clearPhone();
                break;
            case R.id.btn_pwd_clear:
                ILoginPresenter.clearPassword();
                break;
            case R.id.btn_login:
                ILoginPresenter.doLogin(et_login_phone.getText().toString(), et_login_password.getText().toString());
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
