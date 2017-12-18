package com.example.raquelgallo.treino;

import android.widget.EditText;

/**
 * Created by Raquel Gallo on 12/12/2017.
 */

public interface LoginContract {

    interface View {
        void showLoginErrorMessage();

        void showPasswordErrorMessage();

        void showValidUserMessage();

        void showValidPasswordMessage();
    }

    interface Presenter {
        boolean verifyUser(EditText login);

        boolean verifyPassword(EditText senha);
    }
}