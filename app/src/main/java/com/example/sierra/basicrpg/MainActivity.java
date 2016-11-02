package com.example.sierra.basicrpg;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public final static String KVFILENAME = "rpg_basic_savekv";
    public static final String FILENAME = "rpg_basic_save";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void toNewGame(View view){
        Intent intent = new Intent(this, CharacterScreen.class);
        startActivity(intent);
    }

    public void toLoadGame(View view){

        Intent intent = new Intent(this, LoadGame.class);
        startActivity(intent);

    }

    public void toSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void makeToast(View view) {
        Toast.makeText(getApplicationContext(),R.string.versionToast, Toast.LENGTH_LONG).show();
    }


}
