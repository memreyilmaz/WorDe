package com.WorDE.android.app.ui;

import android.content.Context;

import com.WorDE.android.app.R;

import static com.WorDE.android.app.Config.A1;
import static com.WorDE.android.app.Config.A2;
import static com.WorDE.android.app.Config.B1;
import static com.WorDE.android.app.Config.FAV;

public class AssignTitle {
    private String titleLevel;
    private Context context;
    public AssignTitle(Context context){
        this.context = context;
    }
    public String assignTitle(String selectedLevel){
        switch (selectedLevel){
            case A1:
                titleLevel = context.getString(R.string.a1);
                break;
            case A2:
                titleLevel = context.getString(R.string.a2);
                break;
            case B1:
                titleLevel = context.getString(R.string.b1);
                break;
            case FAV:
                titleLevel = context.getString(R.string.user_favourites);
                break;
        }
        return titleLevel;
    }
}
