package com.example.raquelgallo.treino.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raquelgallo.treino.R;
import com.example.raquelgallo.treino.WelcomeContract;
import com.example.raquelgallo.treino.presenter.WelcomePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Raquel Gallo on 13/12/2017.
 */

public class WelcomeActivity extends AppCompatActivity implements WelcomeContract.View {

    @BindView(R.id.navigation_view_btn)
    public BottomNavigationView navigation_view;

    @BindView(R.id.list_view_btn)
    public Button lButton;

    @BindView(R.id.recycler_view_btn)
    public Button rButton;

    @BindView(R.id.float_button_btn)
    public Button fButton;

    @BindView(R.id.text_view_user)
    public TextView welcome_user;

    private String user_name;
    private Intent it;

    private WelcomeContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        user_name = bundle.get("user").toString();
        welcome_user.setText(getString(R.string.welcome_user) + user_name);

        presenter = new WelcomePresenter(this);
        presenter.navigationItemSelected(navigation_view);
    }

    @OnClick({R.id.list_view_btn, R.id.recycler_view_btn, R.id.float_button_btn})
    public void onClickButton(Button button) {
        presenter.openNewActivity(button);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setListagemButtonVisibility() {
        lButton.setVisibility(View.VISIBLE);
        rButton.setVisibility(View.GONE);
        fButton.setVisibility(View.GONE);
    }

    @Override
    public void setRecyclerViewButtonVisibility() {
        lButton.setVisibility(View.GONE);
        rButton.setVisibility(View.VISIBLE);
        fButton.setVisibility(View.GONE);
    }

    @Override
    public void setFloatButtonVisibility() {
        lButton.setVisibility(View.GONE);
        rButton.setVisibility(View.GONE);
        fButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "ERROR. This activity does not exist!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startListViewActivity() {
        it = new Intent(this, ListViewActivity.class);
        startActivity(it);
    }

    @Override
    public void startRecyclerViewActivity() {
        it = new Intent(this, RecyclerViewActivity.class);
        startActivity(it);
    }

    @Override
    public void startFloatButtonActivity() {
        it = new Intent(this, FloatButtonActivity.class);
        startActivity(it);
    }
}