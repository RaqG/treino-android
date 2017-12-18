package com.example.raquelgallo.treino.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.raquelgallo.treino.LoginContract;
import com.example.raquelgallo.treino.R;
import com.example.raquelgallo.treino.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Raquel Gallo on 12/12/2017.
 */

public class MainActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.text_input_layout_login)
    public TextInputLayout inputLayoutLogin;
    @BindView(R.id.text_input_layout_senha)
    public TextInputLayout inputLayoutSenha;
    @BindView(R.id.edit_text_login)
    public EditText editTextLogin;
    @BindView(R.id.edit_text_senha)
    public EditText editTextSenha;

    private LoginContract.Presenter presenter;
    private boolean isVerify;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
    }

    @OnClick(R.id.btn_enviar)
    public void onClickLoginButton() {
        isVerify = presenter.verifyUser(editTextLogin);
        isVerify = presenter.verifyPassword(editTextSenha);

        if (isVerify) {
            Intent it = new Intent(this, WelcomeActivity.class);
            it.putExtra("user", editTextLogin.getText());
            startActivity(it);

            clearEditText();
        }

    }

    private void clearEditText() {
        editTextLogin.setText("");
        editTextSenha.setText("");
    }

    @Override
    public void showLoginErrorMessage() {
        inputLayoutLogin.setError("Usuário Inválido");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    @Override
    public void showPasswordErrorMessage() {
        inputLayoutSenha.setError("Senha Inválida");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    @Override
    public void showValidUserMessage() {
        Toast.makeText(this, "Usuário Válido!", Toast.LENGTH_SHORT).show();
        inputLayoutLogin.setErrorEnabled(false);
    }

    @Override
    public void showValidPasswordMessage() {
        Toast.makeText(this, "Senha Válida!", Toast.LENGTH_SHORT).show();
        inputLayoutSenha.setErrorEnabled(false);
    }
}