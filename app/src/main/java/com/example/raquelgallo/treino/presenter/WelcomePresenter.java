package com.example.raquelgallo.treino.presenter;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.Button;

import com.example.raquelgallo.treino.R;
import com.example.raquelgallo.treino.WelcomeContract;

/**
 * Created by Raquel Gallo on 17/12/2017.
 */

public class WelcomePresenter implements WelcomeContract.Presenter {

    private WelcomeContract.View view;

    public WelcomePresenter(WelcomeContract.View view) {
        this.view = view;
    }

    @Override
    public void navigationItemSelected(BottomNavigationView navigation_view) {
        navigation_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(false);
                switch (item.getItemId()) {
                    case R.id.action_list_view:
                        item.setChecked(true);
                        view.setListagemButtonVisibility();
                        break;
                    case R.id.action_recycler_view:
                        item.setChecked(true);
                        view.setRecyclerViewButtonVisibility();
                        break;
                    case R.id.action_float_button:
                        item.setChecked(true);
                        view.setFloatButtonVisibility();
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void openNewActivity(Button button) {
        switch (button.getText().toString()) {
            case "Listagem":
                view.startListViewActivity();
                break;
            case "RecyclerView":
                view.startRecyclerViewActivity();
                break;
            case "FloatButton":
                view.startFloatButtonActivity();
                break;
            default:
                view.showError();
        }
    }
}