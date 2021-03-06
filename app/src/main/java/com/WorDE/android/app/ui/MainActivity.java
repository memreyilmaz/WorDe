package com.WorDE.android.app.ui;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.WorDE.android.app.R;
import com.WorDE.android.app.ui.helper.MenuClick;
import com.WorDE.android.app.ui.notification.ReminderUtilities;

import static com.WorDE.android.app.Config.A1;
import static com.WorDE.android.app.Config.A2;
import static com.WorDE.android.app.Config.B1;
import static com.WorDE.android.app.Config.FAV;

public class MainActivity extends DrawerActivity implements View.OnClickListener{
    CardView a1LevelButton;
    CardView a2LevelButton;
    CardView b1LevelButton;
    CardView favouriteWordsButton;
    MenuClick menuClick;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        frameLayout = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_main, frameLayout);
        menuClick = new MenuClick(getApplicationContext());
        Toolbar toolbar = findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        a1LevelButton = findViewById(R.id.level_a1_cardview);
        a2LevelButton = findViewById(R.id.level_a2_cardview);
        b1LevelButton = findViewById(R.id.level_b1_cardview);
        favouriteWordsButton = findViewById(R.id.favourite_words_cardview);
        a1LevelButton.setOnClickListener(this::onClick);
        a2LevelButton.setOnClickListener(this::onClick);
        b1LevelButton.setOnClickListener(this::onClick);
        favouriteWordsButton.setOnClickListener(this::onClick);
        setComeBackNotification();
    }

    private void setComeBackNotification() {
        ReminderUtilities.setNotificationPlanner(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.level_a1_cardview:
                menuClick.launchWordListActivity(A1);
                break;
            case R.id.level_a2_cardview:
                menuClick.launchWordListActivity(A2);
                break;
            case R.id.level_b1_cardview:
                menuClick.launchWordListActivity(B1);
                break;
            case R.id.favourite_words_cardview:
                menuClick.launchWordListActivity(FAV);
                break;
            default:
                break;
        }
    }
}