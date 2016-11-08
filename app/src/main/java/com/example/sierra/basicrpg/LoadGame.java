package com.example.sierra.basicrpg;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import java.io.IOException;

import static com.example.sierra.basicrpg.MainActivity.KVFILENAME;

public class LoadGame extends AppCompatActivity {

    public TextView textView;
    public TextView messplay;
    public CheckBox swiilstate;
    public CheckBox swipstate;
    public String s;
    public String se;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);

        textView = (TextView) findViewById(R.id.textView3);
        messplay = (TextView) findViewById(R.id.messplay);
        swiilstate = (CheckBox) findViewById(R.id.il);
        swipstate = (CheckBox) findViewById(R.id.pd);

    }

    public void dispmess(View view) throws IOException {

        SharedPreferences settings = getSharedPreferences(KVFILENAME, 0);
        boolean swiil = settings.getBoolean("iLeveling", true);
        if(swiil)
        {
            swiilstate.setChecked(true);
        }
        boolean swip = settings.getBoolean("permadeath", true);
        if(swip)
        {
            swipstate.setChecked(true);
        }
        s = settings.getString("charName", "");

        messplay.setText(se);
        textView.setText(s);
    }
}
