package com.example.w.sport.presenter.impl;

import android.widget.Toast;

import com.example.w.sport.model.User;
import com.example.w.sport.presenter.inter.IRegisterPresenter;
import com.example.w.sport.view.inter.IRegisterView;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import static cn.bmob.v3.Bmob.getApplicationContext;

/**
 * Created by w on 2018/11/15.
 */
public class RegisterPresenterImpl implements IRegisterPresenter {
    private IRegisterView registerView;
    private User user;
    public RegisterPresenterImpl(IRegisterView registerView){
        this.registerView=registerView;
        user=new User();
    }
    @Override
    public void registerResult(String phone,String password) {
                user.setPhone(phone);
                user.setPassword(password);
                user.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId,BmobException e) {
                        if (e == null) {
                            Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    public void phoneClear() {
        registerView.onPhoneClear();
    }

    @Override
    public void pwdClear() {
        registerView.onPwdClear();
    }
}
