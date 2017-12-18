package com.example.raquelgallo.treino.presenter;

import android.widget.EditText;

import com.example.raquelgallo.treino.LoginContract;

/**
 * Created by Raquel Gallo on 12/12/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public boolean verifyUser(EditText login) {
        if (login.getText().equals("") || login.getText().toString().isEmpty()) {
            view.showLoginErrorMessage();
            return false;
        }
        view.showValidUserMessage();
        return true;
    }

    @Override
    public boolean verifyPassword(EditText senha) {
        if (senha.getText().equals("") || senha.getText().toString().isEmpty()) {
            view.showPasswordErrorMessage();
            return false;
        }
        view.showValidPasswordMessage();
        return true;
    }
}