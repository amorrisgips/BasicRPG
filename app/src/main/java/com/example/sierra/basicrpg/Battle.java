package com.example.sierra.basicrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewAnimator;

public class Battle extends AppCompatActivity {

    ViewAnimator charAttack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        Intent intent = getIntent();
        Character go = (Character) intent.getSerializableExtra("Character");
        charAttack = (ViewAnimator) this.findViewById(R.id.charatk);
    }

    public void startFlip(View view)
    {
        charAttack.showNext();
    }
}
