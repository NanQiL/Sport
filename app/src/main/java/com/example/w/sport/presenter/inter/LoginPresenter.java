package com.example.w.sport.presenter.inter;

/**
 * Created by w on 2018/11/12.
 */
public interface LoginPresenter {
    void doLogin(String phone, String password);
    void clearPhone();
    void clearPassword();
}
