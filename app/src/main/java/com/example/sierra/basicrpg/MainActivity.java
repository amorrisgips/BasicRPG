package com.example.sierra.basicrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toOverworld(View view) {
        Button button = (Button) findViewById(R.id.to_overworld);
        Intent intent = new Intent(this, Overworld.class);
        startActivity(intent);
    }

    public void toNewGame(View view) {
        Intent intent = new Intent(this, CharacterScreen.class);
        startActivity(intent);
    }

    public void toMapLocation(View view) {
        Button button = (Button) findViewById(R.id.to_MapLocation);
        Intent intent = new Intent(this, MapLocation.class);
        startActivity(intent);
    }

    public void makeToast(View view) {
        Toast.makeText(getApplicationContext(),"hi", Toast.LENGTH_LONG).show();
    }
}
