package com.example.raquelgallo.treino;

import android.support.design.widget.BottomNavigationView;
import android.widget.Button;

/**
 * Created by Raquel Gallo on 17/12/2017.
 */

public interface WelcomeContract {

    interface View{

        void setListagemButtonVisibility();

        void setRecyclerViewButtonVisibility();

        void setFloatButtonVisibility();

        void showError();

        void startListViewActivity();

        void startRecyclerViewActivity();

        void startFloatButtonActivity();
    }

    interface Presenter{

        void navigationItemSelected(BottomNavigationView navigation_view);

        void openNewActivity(Button button);
    }
}
