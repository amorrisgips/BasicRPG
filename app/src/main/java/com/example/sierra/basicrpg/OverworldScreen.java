package com.example.sierra.basicrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OverworldScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overworld_screen);
        Intent intent = getIntent();

        Character go = (Character) intent.getSerializableExtra("Character");

        Enemy eL1[] = new Enemy[10];
        eL1[0] = new Enemy("Grem", 1, 1, 1, 1);
        eL1[1] = new Enemy("Troz", 1, 1, 1, 2);
        eL1[2] = new Enemy("Shrom", 1, 1, 1, 3);
        eL1[3] = new Enemy("Blight", 1, 1, 1, 4);
        eL1[4] = new Enemy("Grem", 1, 1, 1, 1);
        eL1[5] = new Enemy("Troz", 1, 1, 1, 2);
        eL1[6] = new Enemy("Shrom", 1, 1, 1, 3);
        eL1[7] = new Enemy("Blight", 1, 1, 1, 4);
        eL1[8] = new Enemy("Grem", 1, 1, 1, 1);
        eL1[9] = new Enemy("Grem", 1, 1, 1, 1);

    }
}
